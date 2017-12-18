/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : coffeeshop

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-12-17 21:52:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', 'Fairfield', 'USA', 'Iowa', '52556');
INSERT INTO `address` VALUES ('2', 'Ottumwa', 'USA', 'Iowa', '64353');

-- ----------------------------
-- Table structure for `orderline`
-- ----------------------------
DROP TABLE IF EXISTS `orderline`;
CREATE TABLE `orderline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7f5oomg479mwt3dm02blnn6r2` (`order_id`),
  KEY `FK_5icddmxagb98vt3oqbxposife` (`product_id`),
  CONSTRAINT `FK_5icddmxagb98vt3oqbxposife` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_7f5oomg479mwt3dm02blnn6r2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderline
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderDate` date NOT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2vo72nhbldmp12cij41nsyx5b` (`person_id`),
  CONSTRAINT `FK_2vo72nhbldmp12cij41nsyx5b` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `enable` bit(1) DEFAULT NULL,
  `encryptedPassword` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tagx64iglr1dxpalbgothv83r` (`address_id`),
  CONSTRAINT `FK_tagx64iglr1dxpalbgothv83r` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'admin@mail.com', '', '$2a$12$uFqAqR91PKlpCWU/Mfj5kektQiyhHicUt..M4e2JbJLczlZvI46BW', 'admin', null, '123456789', 'admin', '1');
INSERT INTO `person` VALUES ('2', 'user@mail.com', '', '$2a$12$RguLmBX5yGc6Z4RycD2QMej.9bWAItwC3MhhJQuqzmLPZRBX14sny', 'user', null, '987654321', 'user', '2');

-- ----------------------------
-- Table structure for `person_role`
-- ----------------------------
DROP TABLE IF EXISTS `person_role`;
CREATE TABLE `person_role` (
  `person_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`person_id`,`role_id`),
  KEY `FK_855jqyd4rc87mktnn2fg74ybf` (`role_id`),
  CONSTRAINT `FK_855jqyd4rc87mktnn2fg74ybf` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_tmcfqcm0lfsikklejfttylv7q` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person_role
-- ----------------------------
INSERT INTO `person_role` VALUES ('1', '1');
INSERT INTO `person_role` VALUES ('2', '2');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `productName` varchar(255) NOT NULL,
  `productType` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '', '2.3', 'Pancakes', 'BREAKFAST');
INSERT INTO `product` VALUES ('2', '', '1.5', 'Crumb Topped Banana', 'BREAKFAST');
INSERT INTO `product` VALUES ('3', '', '3.4', 'Easy Breakfast Casserole', 'BREAKFAST');
INSERT INTO `product` VALUES ('4', '', '4', 'The Bestest Belgian Waffles', 'BREAKFAST');
INSERT INTO `product` VALUES ('5', '', '5.8', 'Spiced Butternut Squash Soup', 'LUNCH');
INSERT INTO `product` VALUES ('6', '', '4.8', 'Tomato Bacon Grilled Cheese', 'LUNCH');
INSERT INTO `product` VALUES ('7', '', '5.3', 'Philly Cheesteak Sandwich with Garlic Mayo', 'LUNCH');
INSERT INTO `product` VALUES ('8', '', '8.1', 'Pork Marsala', 'DINNER');
INSERT INTO `product` VALUES ('9', '', '7.3', 'Pasta Pomodoro', 'DINNER');
INSERT INTO `product` VALUES ('10', '', '7.5', 'Fresh Tomato Shrimp Pasta', 'DINNER');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `role` VALUES ('2', 'ROLE_USER');
