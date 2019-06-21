/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : activiti

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-21 10:31:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `a_employee`
-- ----------------------------
DROP TABLE IF EXISTS `a_employee`;
CREATE TABLE `a_employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `manager_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_employee
-- ----------------------------
INSERT INTO `a_employee` VALUES ('1', '王中军', '123', 'ee@163.com', 'boss', null);
INSERT INTO `a_employee` VALUES ('2', '冯小刚经纪人', '123', 'dd@163.com', 'manager', '1');
INSERT INTO `a_employee` VALUES ('3', '范冰冰经纪人', '123', 'cc@163.com', 'manager', '1');
INSERT INTO `a_employee` VALUES ('4', '冯小刚', '123', 'bb@163.com', 'user', '2');
INSERT INTO `a_employee` VALUES ('5', '范冰冰', '123', 'aa@163.com', 'user', '3');

-- ----------------------------
-- Table structure for `a_leavebill`
-- ----------------------------
DROP TABLE IF EXISTS `a_leavebill`;
CREATE TABLE `a_leavebill` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `days` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `leavedate` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `state` int(11) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_leavebill
-- ----------------------------
