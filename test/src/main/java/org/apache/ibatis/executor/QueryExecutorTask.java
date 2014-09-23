package org.apache.ibatis.executor;

import java.sql.Statement;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.session.ResultHandler;

/**
 * 查询sql执行任务
 * @author yinlei 
 * @since 2013-12-22
 * @param <V> 返回结果泛型类型
 */
public class QueryExecutorTask<V> implements Callable<List<V>> {
	private CountDownLatch latch;
	private StatementHandler statementHandler;
	private Statement stmt;
	private ResultHandler resultHandler;
	
	public QueryExecutorTask(CountDownLatch latch, StatementHandler statementHandler, 
			Statement stmt, ResultHandler resultHandler) {
		super();
		this.latch = latch;
		this.statementHandler = statementHandler;
		this.stmt = stmt;
		this.resultHandler = resultHandler;
	}

	@Override
	public List<V> call() throws Exception {
		latch.countDown();
		return statementHandler.query(stmt, resultHandler);
	}

}
