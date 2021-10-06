/*
 Navicat MySQL Data Transfer

 Source Server         : mysql5
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : springbatch

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 05/10/2021 19:42:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `last_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 'stone', 'Bardett', '1900-01-19 14:11:03');
INSERT INTO `customer` VALUES (2, 'Raymond', 'Pace', '1900-01-19 21:44:30');
INSERT INTO `customer` VALUES (3, 'Armando', 'Logan', '1900-01-19 11:54:28');
INSERT INTO `customer` VALUES (4, 'Latifah', 'Barnett', '1900-01-19 06:00:16');
INSERT INTO `customer` VALUES (5, 'Cassandra', 'Moses', '1900-01-19 06:49:28');
INSERT INTO `customer` VALUES (6, 'Audra', 'Hopkins', '1900-01-19 04:18:10');
INSERT INTO `customer` VALUES (7, 'Upton', 'Morrow', '1900-01-19 05:26:05');
INSERT INTO `customer` VALUES (8, 'Melodie', 'Velasquez', '1900-01-19 11:16:26');
INSERT INTO `customer` VALUES (9, 'Sybill', 'Nolan', '1900-01-19 14:56:51');
INSERT INTO `customer` VALUES (10, 'Glenna', 'little', '1900-01-19 13:15:08');
INSERT INTO `customer` VALUES (11, 'Ingrid', 'Jackson', '1900-01-19 21:36:47');
INSERT INTO `customer` VALUES (12, 'Duncan', 'Castaneda', '1900-01-19 18:31:27');
INSERT INTO `customer` VALUES (13, 'Xaviera', 'Gillespie', '1900-01-19 15:05:22');
INSERT INTO `customer` VALUES (14, 'Rhoda', 'Lancaster', '1900-01-19 15:52:54');
INSERT INTO `customer` VALUES (15, 'Fatima', 'Combs', '1900-01-19 06:58:54');
INSERT INTO `customer` VALUES (16, 'Merrill', 'Hopkins', '1900-01-19 17:36:35');
INSERT INTO `customer` VALUES (17, 'Felicia', 'Vinson', '1900-01-19 20:23:12');
INSERT INTO `customer` VALUES (18, 'Hanae', 'Harvey', '1900-01-19 10:36:49');
INSERT INTO `customer` VALUES (19, 'Ramona', 'Acosta', '1900-01-19 20:03:40');
INSERT INTO `customer` VALUES (20, 'Katelyn', 'Hammond', '1900-01-19 19:05:13');

SET FOREIGN_KEY_CHECKS = 1;
