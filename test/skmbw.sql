/*
Navicat MySQL Data Transfer

Source Server         : mysql-localhsot
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : skmbw

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-10-31 17:35:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app_info`
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `app_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '应用id',
  `app_name` varchar(150) NOT NULL COMMENT '应用的名字，具有唯一性',
  `app_desc` varchar(250) DEFAULT NULL COMMENT '应用描述',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `shards` tinyint(1) DEFAULT NULL COMMENT '数据库是否分表',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='应用信息配置';

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES ('2', 'skmbw', '分布式事务，以及分布式应用相关的配置，管理平台', '2014-10-31 09:45:51', '2014-10-31 09:45:51', '0');
INSERT INTO `app_info` VALUES ('3', 'skmbw2', '用户分区应用', '2014-10-31 09:45:29', '2014-10-31 09:45:29', '1');

-- ----------------------------
-- Table structure for `emp_user`
-- ----------------------------
DROP TABLE IF EXISTS `emp_user`;
CREATE TABLE `emp_user` (
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `user_name` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_user
-- ----------------------------

-- ----------------------------
-- Table structure for `schema_info`
-- ----------------------------
DROP TABLE IF EXISTS `schema_info`;
CREATE TABLE `schema_info` (
  `schema_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'schema主键',
  `schema_name` varchar(150) NOT NULL COMMENT 'schema名字，唯一的',
  `schema_desc` varchar(150) DEFAULT NULL COMMENT 'schema描述',
  `db_type` varchar(50) DEFAULT NULL COMMENT '数据库类型',
  `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
  `port` int(10) DEFAULT NULL COMMENT '该schema所在数据库的端口',
  `jdbc_url` varchar(300) DEFAULT NULL COMMENT 'jdbc连接url',
  `passwords` varchar(50) DEFAULT NULL COMMENT '数据库用户密码',
  `app_id` bigint(20) DEFAULT NULL COMMENT '关联app_info的主键',
  `app_name` varchar(150) DEFAULT NULL COMMENT '应用的名字，和app_id同时更新',
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
  `peer_id` bigint(20) DEFAULT NULL COMMENT '对等库的id',
  `peer_name` varchar(150) DEFAULT NULL COMMENT '对等库的名字',
  `weight` int(3) DEFAULT NULL COMMENT '该数据库的权重',
  `read_weight` int(3) DEFAULT NULL COMMENT '读权重',
  `write_weight` int(3) DEFAULT NULL COMMENT '写权重',
  `startup` tinyint(1) DEFAULT NULL COMMENT '是否应用启动时加载',
  `state` int(3) DEFAULT NULL COMMENT '该schema的状态，1使用中，2可用，3不可用',
  PRIMARY KEY (`schema_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='schema信息配置，其实就是数据源的配置';

-- ----------------------------
-- Records of schema_info
-- ----------------------------
INSERT INTO `schema_info` VALUES ('1', 'skmbw', '配置类信息', 'MySQL', 'localhost', '3306', 'jdbc:mysql://localhost:3306/skmbw', '', '2', null, '1', '2', '100', '100000', '100000', '100000', 'select 1', '1', '0', '0', '1', '100', '1', 'skmbw', '50', null, null, null, null);
INSERT INTO `schema_info` VALUES ('2', 'skmbw2', '测试分区表的数据库', 'MySQL', 'localhost', '3306', 'jdbc:mysql://localhost:3306/skmbw2', '', '3', null, '1', '1', '100', '100000', '100000', '100000', 'select 1', '1', '0', '0', '1', '100', '2', 'skmbw2', '50', null, null, null, null);
INSERT INTO `schema_info` VALUES ('3', 'skmbw3', '测试分区表的数据库3', 'MySQL', 'localhost', '3306', 'jdbc:mysql://localhost:3306/skmbw3', '3416763', '3', null, '1', '1', '100', '100000', '100000', '100000', 'select 1', '1', '0', '0', '1', '100', '2', 'skmbw2', '50', null, null, null, null);

-- ----------------------------
-- Table structure for `sequences`
-- ----------------------------
DROP TABLE IF EXISTS `sequences`;
CREATE TABLE `sequences` (
  `seq_name` varchar(50) NOT NULL DEFAULT '',
  `seq_value` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`seq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequences
-- ----------------------------
INSERT INTO `sequences` VALUES ('ADDR_SEQ', '6');
INSERT INTO `sequences` VALUES ('USER_SEQ', '7');

-- ----------------------------
-- Table structure for `shards_table`
-- ----------------------------
DROP TABLE IF EXISTS `shards_table`;
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
  UNIQUE KEY `table_name_idx` (`table_name`,`schema_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COMMENT='schema下的分区表配置';

-- ----------------------------
-- Records of shards_table
-- ----------------------------
INSERT INTO `shards_table` VALUES ('1', 'skmbw2', '2', 'user', 'user_201410m', 'month', null, null, null, null, 'select 1');
INSERT INTO `shards_table` VALUES ('54', 'skmbw3', '3', 'user', 'user_201410m', 'month', null, null, null, null, 'select 1');
INSERT INTO `shards_table` VALUES ('55', 'skmbw', null, 'shards2_table_201410m4d0df4e7-7b8c-4eea-bf52-fe0ed7266a4d_201410m', 'shards_table', 'month', null, null, '2014-10-31 17:15:53', null, null);
INSERT INTO `shards_table` VALUES ('56', 'skmbw', null, 'shards2_table_201410md172eac5-7e72-44c5-b0eb-6cc77a1c3910_201410m', 'shards_table', 'month', null, null, '2014-10-31 17:16:19', null, null);
INSERT INTO `shards_table` VALUES ('57', 'skmbw', null, 'shards2_table_201410m95ad676f-a82c-4881-9ba6-5b32d80302b1_201410m', 'shards_table', 'month', null, null, '2014-10-31 17:16:22', null, null);
INSERT INTO `shards_table` VALUES ('58', 'skmbw', null, 'shards2_table_201410m5fa408a9-cfa9-49b3-a557-074ebe584de9_201410m', 'shards_table', 'month', null, null, '2014-10-31 17:16:25', null, null);
INSERT INTO `shards_table` VALUES ('59', 'skmbw', null, 'shards2_table_201410md2427447-b719-425c-bd61-aa7e1e1c17b1_201410m', 'shards_table', 'month', null, null, '2014-10-31 17:16:28', null, null);

-- ----------------------------
-- Table structure for `table_detail`
-- ----------------------------
DROP TABLE IF EXISTS `table_detail`;
CREATE TABLE `table_detail` (
  `id` bigint(20) NOT NULL,
  `table_index` bigint(20) NOT NULL,
  `shards_table_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shards_table_id_idx` (`shards_table_id`) USING HASH,
  CONSTRAINT `fk_table_id` FOREIGN KEY (`shards_table_id`) REFERENCES `shards_table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分区表明细信息，一个分区表下共有几个表';

-- ----------------------------
-- Records of table_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` varchar(50) NOT NULL DEFAULT '',
  `C_PASSWORD` varchar(255) DEFAULT NULL,
  `C_USERNAME` varchar(255) DEFAULT NULL,
  `C_REALNAME` varchar(255) DEFAULT NULL,
  `C_EMAIL` varchar(255) DEFAULT NULL,
  `C_ADDRESS` varchar(255) DEFAULT NULL,
  `N_ZIP` int(10) DEFAULT NULL,
  `C_IDENTITYCARD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('40288216486315a20148631baec60004', '1234567', 'yinlei', 'yinlei', null, null, '0', null);
INSERT INTO `t_user` VALUES ('40288216486315a20148631c3a700005', '234567', 'yinlei', '尹雷嘎', null, null, '0', null);
INSERT INTO `t_user` VALUES ('402882164863232c014863792d9b0001', '123456', '尹雷', 'yinlei', null, null, '0', null);
INSERT INTO `t_user` VALUES ('402882164863232c014863d020280002', '12312', 'asdf', '12312', null, null, '0', null);
INSERT INTO `t_user` VALUES ('402882164863232c014863d5b4180003', '12312', '阿瑟斯', '12312', null, null, '0', null);
INSERT INTO `t_user` VALUES ('402882164867dd4e0148687e8f050002', '12ss', 'vv圣达菲', '1更改', null, null, '0', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('100', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('101', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('102', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('103', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('104', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('105', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('106', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('107', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('108', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('109', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('110', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('111', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('112', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('113', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('114', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('115', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('116', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('117', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('118', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('119', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('120', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('121', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('122', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('123', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('124', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('125', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('126', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('127', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('128', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('129', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('130', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('131', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('132', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('133', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('134', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('135', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('136', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('137', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('138', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('139', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('140', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('141', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('142', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('143', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('144', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('145', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('146', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('147', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('148', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('149', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('150', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('151', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('152', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('153', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('154', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('155', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('156', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('157', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('158', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('159', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('160', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('161', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('162', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('163', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('164', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('165', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('166', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('167', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('168', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('169', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('170', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('171', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('172', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('173', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('174', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('175', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('176', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('177', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('178', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('179', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('180', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('181', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('182', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('183', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('184', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('185', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('186', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('187', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('188', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('189', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('190', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('191', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('192', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('193', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('194', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('195', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('196', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('197', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('198', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('199', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('200', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('201', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('202', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('203', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('204', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('205', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('206', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('207', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('208', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('209', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('210', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('211', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('212', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('212121', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('212122', '尹雷', 'tong@126.com', 'admin', '05717878782', '16888888978', 'IBM中国杭州', '123456', '2014-08-11 09:13:04', '1');
INSERT INTO `user` VALUES ('213', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('214', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('215', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('216', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('217', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('218', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('219', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('220', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('221', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('222', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('223', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('224', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('225', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('226', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('227', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('228', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('229', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('230', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('231', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('232', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('233', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('234', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('235', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('236', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('237', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('238', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('239', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('240', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('241', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('242', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('243', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('244', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('245', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('246', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('247', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('248', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('249', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('250', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('251', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('252', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('253', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('254', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('255', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('256', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('257', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('258', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('259', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('260', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('261', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('262', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('263', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('264', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('265', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('26512681050459', '阿斯蒂芬', 'tong@126.com', 'admin', '12312310', '123123123', '微软', '123123', '2014-09-15 16:04:40', '1');
INSERT INTO `user` VALUES ('266', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('267', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('268', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('269', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('270', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('27041997026596', '阿斯蒂芬222', '1231@1231.com', 'admin', '123', '123', '123', '123', '2014-09-15 16:13:31', '1');
INSERT INTO `user` VALUES ('271', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('27103727922531', 'yinlei222', '11@1222.com', 'admin', '', '', 'IBM', '12312', '2014-09-15 16:14:31', '1');
INSERT INTO `user` VALUES ('272', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('273', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('274', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('275', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('276', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('277', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('278', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('279', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('280', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('28027923848530', 'zhogn22', 'zhioagn@126.com', 'admin', '3456346', '45634', 'ibm', '3456345', '2014-09-15 16:29:56', '1');
INSERT INTO `user` VALUES ('281', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('282', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('28233477990708', 'yinlei2', 'asdf@126.com', 'admin', '678678', '789678123', 'wei', '123123', '2014-09-15 16:33:20', '1');
INSERT INTO `user` VALUES ('283', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('28321423575345', 'yinlei222', '1231@1231.com', 'admin', '123123', '123', '123123', '12312', '2014-09-15 16:34:49', '1');
INSERT INTO `user` VALUES ('284', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('28400928073990', 'kjljkl', 'jkj@12.com', 'admin', '678687969', '789689', 'ggg', '1231hk', '2014-09-15 16:36:10', '1');
INSERT INTO `user` VALUES ('285', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('286', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('287', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('288', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('289', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('290', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('291', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('292', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('293', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('294', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('295', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('296', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('297', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('298', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('299', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('300', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('301', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('302', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('303', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('304', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('305', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('306', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('308', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('309', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('310', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('311', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('312', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('313', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('314', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('315', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('316', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('317', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('318', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('319', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('320', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('321', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('322', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('323', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('324', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('325', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('326', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('327', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('328', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('329', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('330', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('331', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('332', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('333', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('334', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('335', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('336', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('337', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('338', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('339', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('340', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('341', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('342', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('343', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('344', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('345', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('346', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('347', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('348', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('349', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('35', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('350', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('351', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('352', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('354', '好家伙', 'tong@126.com', 'admin', '057178787878', '16888888978', 'IBM中国', '123123', '2014-08-07 17:09:25', '1');
INSERT INTO `user` VALUES ('355', '尹雷', 'tong@126.com', 'admin', '05717878782', '16888888978', 'IBM中国杭州', '123456', '2014-08-07 17:18:22', '1');
INSERT INTO `user` VALUES ('356', '', '', 'admin', '', '', '', '', '2014-08-07 17:50:33', '1');
INSERT INTO `user` VALUES ('357', '', '', 'admin', '', '', '', '', '2014-08-07 17:50:35', '1');
INSERT INTO `user` VALUES ('39', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('40', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('42', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('43', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('44', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('45', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('46', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('47', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('48', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('49', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('50', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('51', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('51936dd5-3f51-45c5-a467-b62551d14add_201409m', 'jkjkk22', 'manager1@125.com', 'admin', '123', '123', '123大师傅', '', '2014-09-18 18:23:38', '1');
INSERT INTO `user` VALUES ('52', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('53', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('54', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('55', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('56', 'yinlei', null, null, null, null, null, '123456', null, '1');
INSERT INTO `user` VALUES ('57', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('58', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('59', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('5f1434e3-c979-4a14-9c11-cd5ba08149f5_201409m', 'jkjkk', '1231@1231.com', 'admin', '123123', '123123', '123123', '123123', '2014-09-18 18:12:13', '1');
INSERT INTO `user` VALUES ('60', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('61', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('62', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('63', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('64', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('65', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('66', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('67', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('68', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('69', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('70', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('71', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('72', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('73', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('74', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('75', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('76', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('77', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('78', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('79', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('7b72a07c-0f81-4aef-bfa7-dd40555eef84_201409m', '考虑考虑', 'sd@126.com', 'admin', '1237812', '127878', '1278', '123jk', '2014-09-19 09:16:56', '1');
INSERT INTO `user` VALUES ('7db00d24-92fc-4145-b6b8-33b2cb7a0b10_201409m', 'yinlei22333', 'asdf@126.com', 'admin', '123123123', '123123', 'IBM', '1213', '2014-09-18 18:08:11', '1');
INSERT INTO `user` VALUES ('80', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('81', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('82', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('83', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('84', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('85', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('86', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('87', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('88', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('89', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('90', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('91', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('92', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('93', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('94', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('95', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('96', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('97', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('98', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('99', 'yinlei', null, null, null, null, null, '123456', null, null);
INSERT INTO `user` VALUES ('d53f85c7-c251-441b-a469-d413ea776a26_201409m', 'jkjkk', 'manager1@125.com', 'admin', '123', '123', '123', '123', '2014-09-18 18:14:22', '1');
INSERT INTO `user` VALUES ('def849f9-4107-4c2f-bef1-59e6b6f4b94f_201409m', 'jkjkk22', 'manager1@125.com', 'admin', '123', '123', '123大师傅', '', '2014-09-18 18:21:21', '1');

-- ----------------------------
-- Table structure for `user_201409m`
-- ----------------------------
DROP TABLE IF EXISTS `user_201409m`;
CREATE TABLE `user_201409m` (
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

-- ----------------------------
-- Records of user_201409m
-- ----------------------------
INSERT INTO `user_201409m` VALUES ('28682414096208', 'yinlei', 'tongku@126.com', 'admin', '057134118900', '13556789090', 'IBM', '123456', '2014-09-16 16:32:29', '1');
INSERT INTO `user_201409m` VALUES ('42e55d92-a8c1-4d40-ba66-7c832943a797_201409m', '尹雷2', 'tongku@126.com', 'admin', '3456346', '13556789090', 'IBM', '123456', '2014-09-22 10:49:15', '1');
INSERT INTO `user_201409m` VALUES ('466cfe93-75f7-4e72-97d8-0c0484029283_201409m', 'yinlei22', '1231@1231.com', 'admin', '12312310', '13556789090', '121', '', '2014-09-30 09:37:23', '1');
INSERT INTO `user_201409m` VALUES ('4d8d4abf-5ed6-4791-8209-a7ee20c650e9_201409m', '考虑考虑', 'sd@126.com', 'admin', '1237812', '127878', '1278', '', '2014-09-19 09:22:50', '1');
INSERT INTO `user_201409m` VALUES ('5b031ea3-605a-4ce0-93dd-322a9b636b1c_201409m', 'yinlei22', '1231@1231.com', 'admin', '12312310', '13556789090', '121', '11221', '2014-09-30 09:30:08', '1');
INSERT INTO `user_201409m` VALUES ('76a729c7-657e-43f4-b384-06df62f82d9f_201409m', '尹雷2', 'hkhj@126.com', 'admin', '178968', '1289788789', 'ibm', '12312', '2014-09-22 10:49:15', '1');
INSERT INTO `user_201409m` VALUES ('af29080e-ec5b-45a4-888f-dba06b55dc5d_201409m', 'yinlei22', 'asdf@126.com', 'admin', '12312310', '13556789090', 'IBM', '', null, '1');
INSERT INTO `user_201409m` VALUES ('ddd57c2f-a5a1-426d-b258-fa93713e202d_201409m', 'yinlei2', 'tongku@126.com', 'admin', '3456346', '13556789090', 'IBM', '', '2014-09-22 10:49:15', '1');
INSERT INTO `user_201409m` VALUES ('f80a9e57-7f94-4860-8fe7-a153d927e767_201409m', 'yinlei22', '1231@1231.com', 'admin', '12312310', '13556789090', '121', '', '2014-09-30 09:40:41', '1');

-- ----------------------------
-- Table structure for `user_201410m`
-- ----------------------------
DROP TABLE IF EXISTS `user_201410m`;
CREATE TABLE `user_201410m` (
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

-- ----------------------------
-- Records of user_201410m
-- ----------------------------

-- ----------------------------
-- Table structure for `user_201411m`
-- ----------------------------
DROP TABLE IF EXISTS `user_201411m`;
CREATE TABLE `user_201411m` (
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

-- ----------------------------
-- Records of user_201411m
-- ----------------------------
