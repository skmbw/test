CREATE TABLE `app_info` (
  `app_id` bigint(20) NOT NULL,
  `app_name` varchar(150) NOT NULL,
  `app_desc` varchar(250) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `schema_info` (
  `schema_id` bigint(20) NOT NULL,
  `schema_name` varchar(150) NOT NULL,
  `schema_desc` varchar(150) DEFAULT NULL,
  `db_type` varchar(50) DEFAULT NULL COMMENT '数据库类型',
  `ip` varchar(50) DEFAULT NULL,
  `port` int(10) DEFAULT NULL,
  `jdbc_url` varchar(300) DEFAULT NULL COMMENT 'jdbc连接url',
  `passwords` varchar(50) DEFAULT NULL,
  `app_id` bigint(20) DEFAULT NULL COMMENT '关联app_info的主键',
  `initial_size` int(10) DEFAULT NULL COMMENT '连接池初始化大小',
  `min_idle` int(10) DEFAULT NULL COMMENT '连接池最小空闲数',
  `max_active` int(10) DEFAULT NULL COMMENT '连接池最大连接数',
  `max_wait` bigint(20) DEFAULT NULL COMMENT '获取连接的最大等待时间，单位毫秒',
  `between_eviction_runs` bigint(20) DEFAULT NULL COMMENT '间隔多久才进行一次检测，检测需要关闭的空闲连接，单位毫秒',
  `min_evictable_idle` bigint(20) DEFAULT NULL COMMENT '一个连接在池中最小生存的时间，单位是毫秒',
  `validation_query` varchar(300) DEFAULT NULL COMMENT '验证连接的sql',
  `test_while_idle` tinyint(1) DEFAULT NULL COMMENT '空闲时清理连接',
  `test_on_borrow` tinyint(1) DEFAULT NULL COMMENT '是否验证获取的连接',
  `test_on_return` tinyint(1) DEFAULT NULL COMMENT '是否验证归还的连接',
  `pool_propared_stmt` tinyint(1) DEFAULT NULL COMMENT '是否池化预处理语句',
  `max_pstmt_per_conn` int(10) DEFAULT NULL COMMENT '每个连接的最大预处理语句数',
  PRIMARY KEY (`schema_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shards_table` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `schema_name` varchar(150) NOT NULL COMMENT 'table schema',
  `schema_id` bigint(20) DEFAULT NULL,
  `table_name` varchar(100) NOT NULL COMMENT '表名',
  `current_table` varchar(100) NOT NULL COMMENT '现在的表名',
  `strategy` varchar(50) NOT NULL COMMENT '分区策略',
  `from_index` bigint(20) DEFAULT NULL COMMENT '表id开始记录',
  `end_index` bigint(20) DEFAULT NULL COMMENT '表id结束记录',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `create_sql` varchar(500) DEFAULT NULL COMMENT '创建表的sql语句',
  PRIMARY KEY (`id`),
  UNIQUE KEY `table_name_idx` (`table_name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

CREATE TABLE `table_detail` (
  `id` bigint(20) NOT NULL,
  `table_index` bigint(20) NOT NULL,
  `shards_table_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shards_table_id_idx` (`shards_table_id`) USING HASH,
  CONSTRAINT `fk_table_id` FOREIGN KEY (`shards_table_id`) REFERENCES `shards_table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `user_account` varchar(100) DEFAULT NULL,
  `super_admin` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `mobile_phone` varchar(20) DEFAULT NULL,
  `company` varchar(200) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `create_date` datetime DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sequences` (
  `seq_name` varchar(50) NOT NULL DEFAULT '',
  `seq_value` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`seq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `emp_user` (
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `user_name` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;