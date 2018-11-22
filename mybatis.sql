/*
Navicat MySQL Data Transfer

Source Server         : 192.168.33.12
Source Server Version : 50724
Source Host           : 192.168.33.12:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-11-21 20:16:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `price` float(10,1) DEFAULT NULL,
  `detail` text COMMENT '描述',
  `pic` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '音箱3', null, null, null, '2018-10-13 00:00:00');
INSERT INTO `items` VALUES ('2', '袜子', '10.0', null, null, null);

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) DEFAULT NULL COMMENT '订单id',
  `items_id` int(11) DEFAULT NULL COMMENT '商品id',
  `items_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '1', '1', '2');
INSERT INTO `orderdetail` VALUES ('2', '2', '1', '3');
INSERT INTO `orderdetail` VALUES ('3', '1', '2', '4');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL COMMENT '订单号',
  `createtime` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', 'bbb', null, null);
INSERT INTO `orders` VALUES ('2', '1', 'aaa', null, null);
INSERT INTO `orders` VALUES ('3', '2', 'aaa', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `sex` char(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'liwu23', '1', '2018-10-17', '福田');
INSERT INTO `user` VALUES ('2', 'zhangsan', '1', '2018-10-19', '福田');
INSERT INTO `user` VALUES ('3', 'zhangsan2', '1', '2018-10-19', '福田');
INSERT INTO `user` VALUES ('4', '刘田', '1', '2018-10-19', '福田');
INSERT INTO `user` VALUES ('8', '张事故', '0', '2018-11-11', '深圳');
INSERT INTO `user` VALUES ('9', '张事故', '0', '2018-11-01', '深圳');
