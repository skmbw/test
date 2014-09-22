package org.apache.ibatis.executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.vteba.tx.jdbc.params.QueryBean;

/**
 * @author Clinton Begin
 */
public class SimpleExecutor extends BaseExecutor {
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleExecutor.class);
	
	public SimpleExecutor(Configuration configuration, Transaction transaction) {
		super(configuration, transaction);
	}

	public int doUpdate(MappedStatement ms, Object parameter)
			throws SQLException {
		Statement stmt = null;
		try {
			Configuration configuration = ms.getConfiguration();
			List<String> sqlList = ms.getSqlList();
			int size = sqlList.size();
			if (size == 1) {
				StatementHandler handler = configuration.newStatementHandler(this,
						ms, parameter, RowBounds.DEFAULT, null, null);
				stmt = prepareStatement(handler, ms.getStatementLog());
				return handler.update(stmt);
			} else {
				int result = 0;
				CountDownLatch latch = new CountDownLatch(size);
				ExecutorService service = Executors.newCachedThreadPool();
				for (String sql : sqlList) {
					ms.getBoundSql().setSql(sql);
					StatementHandler handler = configuration.newStatementHandler(this,
							ms, parameter, RowBounds.DEFAULT, null, null);
					stmt = prepareStatement(handler, ms.getStatementLog());
					UpdateExecutorTask task = new UpdateExecutorTask(latch, handler, stmt);
					Future<Integer> future = service.submit(task);
					try {
						result += future.get();
					} catch (InterruptedException e) {
						LOGGER.warn("update获取子线程结果时，中断异常");
					} catch (ExecutionException e) {
						LOGGER.warn("update获取子线程结果时，执行异常");
					}
				}
				try {
					latch.await(5, TimeUnit.SECONDS);// 5秒超时
				} catch (InterruptedException e) {
					LOGGER.warn("线程同步等待，中断异常");
				}
				return result;
			}
		} finally {
			closeStatement(stmt);
		}
	}

	public <E> List<E> doQuery(MappedStatement ms, Object parameter,
			RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql)
			throws SQLException {
		Statement stmt = null;
		try {
			Configuration configuration = ms.getConfiguration();
			List<E> result = new ArrayList<E>();
			List<String> sqlList = boundSql.getSqlList();
			int size = sqlList.size();
			if (size == 1) {// 只有一条sql直接在主线程执行
				StatementHandler handler = configuration.newStatementHandler(
						wrapper, ms, parameter, rowBounds, resultHandler,
						boundSql);
				stmt = prepareStatement(handler, ms.getStatementLog());
				result = handler.<E> query(stmt, resultHandler);
			} else {// 多条语句开启线程池，在线程池中执行
				CountDownLatch latch = new CountDownLatch(size);
				ExecutorService service = Executors.newCachedThreadPool();
				for (String sql : sqlList) {// 这里使用多线程处理
					boundSql.setSql(sql);
					StatementHandler handler = configuration.newStatementHandler(
							wrapper, ms, parameter, rowBounds, resultHandler, boundSql);
					stmt = prepareStatement(handler, ms.getStatementLog());
					QueryExecutorTask<E> task = new QueryExecutorTask<E>(latch, handler, stmt, resultHandler);
					Future<List<E>> future = service.submit(task);
					
					try {
						result.addAll(future.get());
					} catch (InterruptedException e) {
						LOGGER.warn("query获取子线程结果时，中断异常");
					} catch (ExecutionException e) {
						LOGGER.warn("query获取子线程结果时，执行异常");
					}
				}
				
				try {
					latch.await(5, TimeUnit.SECONDS);// 5秒超时
				} catch (InterruptedException e) {
					LOGGER.warn("query线程同步等待，中断异常");
				}
				QueryBean queryBean = (QueryBean) parameter;
				if (queryBean.isStats()) {
					result = resolveStatsResult(ms, result);
				}
			}
			return result;
		} finally {
			closeStatement(stmt);
		}
	}

	/**
	 * 处理简单值的统计查询。返回POJO的统计查询，要另外处理。
	 * @param ms 映射语句
	 * @param result 中间结果
	 * @return 返回的处理结果
	 */
	@SuppressWarnings("unchecked")
	private <E> List<E> resolveStatsResult(MappedStatement ms, List<E> result) {
		Class<?> type = ms.getResultMaps().get(0).getType();
		
		if (type == Integer.class) {
			int i = 0;
			for (E in : result) {
				i += (Integer)in;
			}
			result = (List<E>) Lists.newArrayList(i);
		} else if (type == Double.class) {
			double i = 0;
			for (E in : result) {
				i += (Double)in;
			}
			result = (List<E>) Lists.newArrayList(i);
		} else if (type == Long.class) {
			long i = 0;
			for (E in : result) {
				i += (Long)in;
			}
			result = (List<E>) Lists.newArrayList(i);
		} else {
			throw new IllegalStateException("统计查询结果类型错误");
		}
		return result;
	}

	public List<BatchResult> doFlushStatements(boolean isRollback)
			throws SQLException {
		return Collections.emptyList();
	}

	private Statement prepareStatement(StatementHandler handler,
			Log statementLog) throws SQLException {
		Statement stmt;
		Connection connection = getConnection(statementLog);
		stmt = handler.prepare(connection);
		handler.parameterize(stmt);
		return stmt;
	}

}
