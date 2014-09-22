package org.apache.ibatis.executor;

import java.sql.Statement;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

import org.apache.ibatis.executor.statement.StatementHandler;

/**
 * 更新sql执行任务
 * @author yinlei 
 * @since 2013-12-22
 * @param <V>
 */
public class UpdateExecutorTask implements Callable<Integer> {
	private CountDownLatch latch;
	private StatementHandler statementHandler;
	private Statement stmt;
	
	public UpdateExecutorTask(CountDownLatch latch, StatementHandler statementHandler, 
			Statement stmt) {
		super();
		this.latch = latch;
		this.statementHandler = statementHandler;
		this.stmt = stmt;
	}

	@Override
	public Integer call() throws Exception {
		latch.countDown();
		return statementHandler.update(stmt);
	}

}
