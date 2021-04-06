/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : ems

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 06/04/2021 15:40:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS ems;

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int UNSIGNED NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`user_id`) USING BTREE,
  CONSTRAINT `id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES (1, 10000, '系统已启用', '2021-04-03 16:32:36', 0);
INSERT INTO `board` VALUES (2, 10000, '第二条公告', '2021-04-05 12:14:07', 0);

-- ----------------------------
-- Table structure for current
-- ----------------------------
DROP TABLE IF EXISTS `current`;
CREATE TABLE `current`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int UNSIGNED NOT NULL,
  `used` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `last_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `id_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of current
-- ----------------------------

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int UNSIGNED NOT NULL,
  `used` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_user_id2`(`user_id`) USING BTREE,
  CONSTRAINT `id_user_id2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------

-- ----------------------------
-- Table structure for price
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `price` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `elect_type` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of price
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '账号',
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '姓名',
  `phone` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '手机号码',
  `gender` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '性别',
  `address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '地址',
  `elect_type` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '商用1/民用0',
  `id_number` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '身份证号',
  `password` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `is_admin` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否管理员',
  `register_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10000, 'admin', '13388665566', 'male', 'no addr', 0, NULL, '123456', 1, '2021-04-02 21:59:32');
INSERT INTO `user` VALUES (20001, '李四', '18822424756', '女', '安徽省合肥市蜀山区蜀南庭苑1栋101', 0, '340102198912131538', '123456', 0, '2021-04-05 18:43:56');
INSERT INTO `user` VALUES (20002, '张三', '13344334333', '男', '无地址', 0, '340102198709121314', '123456', 0, '2021-04-04 21:26:55');

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int UNSIGNED NULL DEFAULT NULL,
  `old_balance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `operate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `new_balance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `operate_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_2`(`user_id`) USING BTREE,
  CONSTRAINT `id_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wallet
-- ----------------------------
INSERT INTO `wallet` VALUES (1, 20001, '0', '充值_支付宝', '100', '2021-04-05 14:31:41');
INSERT INTO `wallet` VALUES (2, 20001, '100', '年费', '99', '2021-04-05 14:31:27');
INSERT INTO `wallet` VALUES (3, 20001, '99', '消费', '90.2', '2021-04-05 18:26:09');
INSERT INTO `wallet` VALUES (4, 20001, '90.2', '消费', '90.1', '2021-04-05 18:26:35');
INSERT INTO `wallet` VALUES (5, 20001, '90.1', '测试', '90.0', '2021-04-05 18:29:42');
INSERT INTO `wallet` VALUES (6, 20001, '90.0', '测试', '89.9', '2021-04-05 18:29:44');
INSERT INTO `wallet` VALUES (7, 20001, '89.9', '测试', '88.8', '2021-04-05 18:29:46');
INSERT INTO `wallet` VALUES (8, 20001, '89.8', '测试', '88.7', '2021-04-05 18:29:48');
INSERT INTO `wallet` VALUES (9, 20001, '89.7', '测试', '88.6', '2021-04-05 18:29:52');
INSERT INTO `wallet` VALUES (10, 20001, '89.6', '测试', '88.5', '2021-04-05 18:29:54');
INSERT INTO `wallet` VALUES (11, 20001, '89.5', '测试', '88.4', '2021-04-05 18:29:57');
INSERT INTO `wallet` VALUES (12, 20001, '89.4', '测试', '88.3', '2021-04-05 18:29:59');

SET FOREIGN_KEY_CHECKS = 1;
