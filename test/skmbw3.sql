/*
Navicat MySQL Data Transfer

Source Server         : mysql-localhsot
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : skmbw3

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-10-31 17:35:41
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
INSERT INTO `user_201409m` VALUES ('cb7f1f4b-b385-4898-a6b3-4e423e5ad09b_201410m', 'yinlei', 'tongku@126.com', 'admin', '178787878', '18777871221', 'ibm', '', '2014-10-31 14:39:26', '1');
INSERT INTO `user_201409m` VALUES ('ff1ff3ad-3679-4efb-aeef-ead856081634_201410m', 'yinlei', 'tongku@126.com', 'admin', '178787878', '18777871221', 'ibm', '', '2014-10-31 14:39:33', '1');

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
INSERT INTO `user_201410m` VALUES ('13b7c509-56b3-438d-a9bf-012aa8cb0492_201410m', 'yinlei22', 'tongku@126.com', 'admin', '3456346', '18777871221', 'ibm', '', '2014-10-31 17:16:22', '1');
INSERT INTO `user_201410m` VALUES ('4dc67f2a-cb3d-469d-8d39-64f51c1c2f5a_201410m', 'yinlei22', 'tongku@126.com', 'admin', '3456346', '18777871221', 'ibm', '', '2014-10-31 17:16:28', '1');

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
