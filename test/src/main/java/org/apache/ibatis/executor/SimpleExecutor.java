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

/**
 * @author Clinton Begin
 */
public class SimpleExecutor extends BaseExecutor {

	public SimpleExecutor(Configuration configuration, Transaction transaction) {
		super(configuration, transaction);
	}

	public int doUpdate(MappedStatement ms, Object parameter)
			throws SQLException {
		Statement stmt = null;
		try {
			Configuration configuration = ms.getConfiguration();
			StatementHandler handler = configuration.newStatementHandler(this,
					ms, parameter, RowBounds.DEFAULT, null, null);
			stmt = prepareStatement(handler, ms.getStatementLog());
			return handler.update(stmt);
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
			} else {
				CountDownLatch latch = new CountDownLatch(size);
				ExecutorService service = Executors.newCachedThreadPool();
				for (String sql : sqlList) {// 这里使用多线程处理
					boundSql.setSql(sql);
					StatementHandler handler = configuration.newStatementHandler(
							wrapper, ms, parameter, rowBounds, resultHandler,
							boundSql);
					stmt = prepareStatement(handler, ms.getStatementLog());
					ExecutorTask<E> task = new ExecutorTask<E>(latch, handler, stmt, resultHandler);
					Future<List<E>> future = service.submit(task);
					
					try {
						result.addAll(future.get());
					} catch (InterruptedException e) {
						
					} catch (ExecutionException e) {
						
					}
				}
				try {
					latch.await(5, TimeUnit.SECONDS);// 5秒中超时
				} catch (InterruptedException e) {
					// 线程等待，中断异常
				}
			}
			return result;
		} finally {
			closeStatement(stmt);
		}
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
