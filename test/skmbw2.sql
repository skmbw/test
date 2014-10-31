/*
Navicat MySQL Data Transfer

Source Server         : mysql-localhsot
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : skmbw2

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-10-31 17:35:31
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `user_201409m` VALUES ('19dd1dab-1fbc-48bd-9fdb-018e98fe3e45_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 15:09:57', '1');
INSERT INTO `user_201409m` VALUES ('1a2810a8-6534-4e6b-825c-8c044a1697f6_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '1222', '2014-10-08 14:51:42', '1');
INSERT INTO `user_201409m` VALUES ('1b11ce0a-5bc5-4d05-85b2-13d1811bb4c0_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 15:21:20', '1');
INSERT INTO `user_201409m` VALUES ('1f4fc436-62ac-4e53-bd97-e271af4a9f85_201409m', 'yinlei22', '1231@1231.com', 'admin', '12312310', '13556789090', '121', '', '2014-09-30 11:09:53', '1');
INSERT INTO `user_201409m` VALUES ('2ef3630b-aa53-4490-86af-a53dd0634504_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 17:15:40', '1');
INSERT INTO `user_201409m` VALUES ('32791ca8-8ff2-446f-9eab-1b54358e6083_201409m', 'yinlei22', 'tongku@126.com', 'admin', '12312310', '13556789090', 'IBM', '211', '2014-09-30 13:41:51', '1');
INSERT INTO `user_201409m` VALUES ('415d3d43-04b8-4eca-b49a-1b93413aef87_201409m', 'yinlei22', 'tongku@126.com', 'admin', '12312310', '13556789090', 'IBM', '', '2014-09-30 13:43:55', '1');
INSERT INTO `user_201409m` VALUES ('4c6c78f7-acd4-4488-9c07-a24f3c753b92_201410m', 'jkjkk22', 'tongku@126.com', 'admin', '45678', '123123', '1212', '', '2014-10-09 10:13:16', '1');
INSERT INTO `user_201409m` VALUES ('5117e187-1d14-46a1-975e-4b98dc7a6f50_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 15:25:50', '1');
INSERT INTO `user_201409m` VALUES ('554bcd14-7cfb-4e0e-a589-ac84fb73f4ae_201410m', 'yinlei', 'tongku@126.com', 'admin', '178787878', '18777871221', 'ibm', '123456', '2014-10-31 14:39:11', '1');
INSERT INTO `user_201409m` VALUES ('613467d6-cd15-4c9d-9242-545b07ce037a_201409m', 'yinlei22', '1231@1231.com', 'admin', '12312310', '13556789090', '121', '', '2014-09-30 10:36:57', '1');
INSERT INTO `user_201409m` VALUES ('6472f686-8a43-4ae1-ac7f-11ef07f7bdcd_201409m', 'yinlei22', '1231@1231.com', 'admin', '12312310', '13556789090', '121', '', '2014-09-30 10:24:42', '1');
INSERT INTO `user_201409m` VALUES ('735c2a1b-f1f9-489f-9c29-30480adc76ab_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 15:26:07', '1');
INSERT INTO `user_201409m` VALUES ('7df917e7-d70b-4085-acb8-19dd113a5099_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 15:18:29', '1');
INSERT INTO `user_201409m` VALUES ('8708db5b-0ca2-47e4-84d9-a9deb36ddd56_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 16:33:37', '1');
INSERT INTO `user_201409m` VALUES ('8a07fdb3-1ab6-4a5d-a51b-27d82ae8c96b_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 17:18:54', '1');
INSERT INTO `user_201409m` VALUES ('a4d5fdba-282e-4627-bc84-785769c9a4a5_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 16:39:02', '1');
INSERT INTO `user_201409m` VALUES ('abbfd9b2-8cee-4f6f-9c15-a623d2142a97_201409m', 'yinlei22', '1231@1231.com', 'admin', '12312310', '13556789090', '121', '', '2014-09-30 10:54:39', '1');
INSERT INTO `user_201409m` VALUES ('c6b1be54-1f84-4f8b-a892-bdbfae262c4e_201410m', 'jkjkk22', 'tongku@126.com', 'admin', '45678', '123123', '1212', '', '2014-10-09 10:00:49', '1');
INSERT INTO `user_201409m` VALUES ('cd38e126-4a95-4803-83a9-cc1add462a59_201409m', 'yinlei2', 'tongku@126.com', 'admin', '12312310', '1289788789', '12312', '12121', '2014-09-30 11:11:01', '1');
INSERT INTO `user_201409m` VALUES ('e281c7d6-ed8d-42a7-a03b-43de029e254f_201410m', 'yinlei2', '1231@1231.com', 'admin', '3456346', '13556789090', '121', '', '2014-10-08 15:25:14', '1');
INSERT INTO `user_201409m` VALUES ('fd996f3a-9b41-4b0d-b03c-b16ebebac218_201410m', 'jkjkk22', 'tongku@126.com', 'admin', '45678', '123123', '1212', '123', '2014-10-09 09:58:49', '1');

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
INSERT INTO `user_201410m` VALUES ('615a1ab7-7a67-49b6-aa0a-0160cb1d4092_201410m', 'yinlei22', 'tongku@126.com', 'admin', '3456346', '18777871221', 'ibm', '', '2014-10-31 17:16:25', '1');
INSERT INTO `user_201410m` VALUES ('92a643b4-6c53-4d47-a316-619458bf003d_201410m', 'yinlei22', 'tongku@126.com', 'admin', '3456346', '18777871221', 'ibm', '123456', '2014-10-31 17:16:19', '1');
INSERT INTO `user_201410m` VALUES ('c5334c13-38f1-44d6-b7bd-6dc424e8188d_201410m', 'yinlei22', 'tongku@126.com', 'admin', '12312310', '13556789090', 'IBM', '123456', '2014-10-31 17:15:53', '1');

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
