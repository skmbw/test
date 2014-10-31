package com.vteba.service.sharding.cache;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.InitializingBean;

import com.vteba.table.model.ShardsTable;
import com.vteba.table.service.spi.ShardsTableService;
import com.vteba.tx.jdbc.mybatis.cache.ShardsTableCache;
import com.vteba.tx.jdbc.params.QueryBean;
import com.vteba.tx.matrix.info.ShardsTables;

@Named
public class ShardingTableCacheService implements InitializingBean, ShardsTableCache {
	private static final ConcurrentMap<String, ShardsTables> CACHE = new ConcurrentHashMap<String, ShardsTables>();
	
	@Inject
	private ShardsTableService shardsTableServiceImpl;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		QueryBean queryBean = new QueryBean();
		ShardsTable params = new ShardsTable();
		queryBean.setParams(params);
		List<ShardsTable> shardsTableList = shardsTableServiceImpl.queryList(queryBean);
		for (ShardsTable table : shardsTableList) {
			CACHE.put(table.getTableName(), table);
		}
	}

	@Override
	public ShardsTables get(String tableName) {
		return CACHE.get(tableName);
	}

	@Override
	public void put(String tableName, ShardsTables tableInfo) {
		CACHE.put(tableName, tableInfo);
	}

}
