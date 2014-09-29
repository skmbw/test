package org.apache.ibatis.mapping;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.transaction.TransactionFactory;

import com.vteba.service.tenant.SchemaContextHolder;

/**
 * 可以设置数据源
 * @author Clinton Begin
 * @author yinlei
 */
public final class Environment {
	private final String id;
	private final TransactionFactory transactionFactory;
	private DataSource dataSource;// 默认数据源
	
	// 所持有的所有的数据源，包括默认数据源
	private Map<String, DataSource> proxyDataSource;

	public Environment(String id, TransactionFactory transactionFactory,
			DataSource dataSource) {
		if (id == null) {
			throw new IllegalArgumentException(
					"Parameter 'id' must not be null");
		}
		if (transactionFactory == null) {
			throw new IllegalArgumentException(
					"Parameter 'transactionFactory' must not be null");
		}
		this.id = id;
		if (dataSource == null) {
			throw new IllegalArgumentException(
					"Parameter 'dataSource' must not be null");
		}
		this.transactionFactory = transactionFactory;
		this.dataSource = dataSource;
	}

	public static class Builder {
		private String id;
		private TransactionFactory transactionFactory;
		private DataSource dataSource;

		public Builder(String id) {
			this.id = id;
		}

		public Builder transactionFactory(TransactionFactory transactionFactory) {
			this.transactionFactory = transactionFactory;
			return this;
		}

		public Builder dataSource(DataSource dataSource) {
			this.dataSource = dataSource;
			return this;
		}

		public String id() {
			return this.id;
		}

		public Environment build() {
			return new Environment(this.id, this.transactionFactory,
					this.dataSource);
		}

	}

	public String getId() {
		return this.id;
	}

	public TransactionFactory getTransactionFactory() {
		return this.transactionFactory;
	}

	public DataSource getDataSource() {
		String schema = SchemaContextHolder.getSchema();
		if (schema != null) {
			return proxyDataSource.get(schema);
		} else {
			return this.dataSource;
		}
	}

	/**
	 * 可以动态替换底层的数据源
	 * @param dataSource 数据源
	 * @author yinlei
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Map<String, DataSource> getProxyDataSource() {
		return proxyDataSource;
	}

	public void setProxyDataSource(Map<String, DataSource> proxyDataSource) {
		this.proxyDataSource = proxyDataSource;
	}

}
