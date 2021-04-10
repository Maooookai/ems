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

 Date: 11/04/2021 01:22:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE if not exists ems;

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board`
(
    `id`          int UNSIGNED                                                   NOT NULL AUTO_INCREMENT,
    `user_id`     int UNSIGNED                                                   NULL     DEFAULT NULL,
    `content`     varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL,
    `update_time` datetime                                                       NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  tinyint UNSIGNED                                               NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `id` (`user_id`) USING BTREE,
    CONSTRAINT `id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board`
VALUES (1, 10000, '系统已启用', '2021-04-03 16:32:36', 0);
INSERT INTO `board`
VALUES (2, 10000, '第二条公告', '2021-04-05 12:14:07', 0);
INSERT INTO `board`
VALUES (3, 10000,
        '中国南方电网公司是中央管理的国有重要骨干企业，由国务院国资委履行出资人职责。公司负责投资、建设和经营管理南方区域电网，参与投资、建设和经营相关的跨区域输变电和联网工程，为广东、广西、云南、贵州、海南五省区和港澳地区提供电力供应服务保障；从事电力购销业务，负责电力交易与调度；从事国内外投融资业务；自主开展外贸流通经营、国际合作、对外工程承包和对外劳务合作等业务。\r\n\r\n　　公司总部设有20个部门，下设南网总调、后勤管理中心、年金中心3个直属机构，超高压公司、南网党校(南网领导力学院、南网培训中心)、北京分公司3家分公司；广东、广西、云南、贵州、海南电网公司，深圳供电局、调峰调频公司、产业投资集团、鼎元资产公司、资本控股公司、南网国际公司、南网数研院、南网物资公司、南网能源院14家全资子公司；南网能源公司、南网财务公司、鼎和保险公司、云南国际公司、南网科研院、广州电力交易中心、南网传媒公司7家控股子公司。',
        '2021-04-06 22:38:54', 0);
INSERT INTO `board`
VALUES (4, 10000,
        '国家电网有限公司成立于2001年12月29日，是根据《公司法》设立的中央直接管理的国有独资公司，注册资本8295亿元，以投资建设运营电网为核心业务，是关系国家能源安全和国民经济命脉的特大型国有重点骨干企业。\r\n\r\n公司经营区域覆盖我国26个省（自治区、直辖市），供电范围占国土面积的88%，供电人口超过11亿。2020年，公司在《财富》世界500强中排名第3位。近20多年来，国家电网持续创造全球特大型电网最长安全纪录，建成多项特高压输电工程，成为世界上输电能力最强、新能源并网规模最大的电网，专利拥有量连续10年位列央企第一。公司投资运营菲律宾、巴西、葡萄牙、澳大利亚、意大利、希腊、阿曼、智利和中国香港等9个国家和地区的骨干能源网，连续16年获得国务院国资委业绩考核A级，连续8年获得标准普尔、穆迪、惠誉三大国际评级机构国家主权级信用评级。',
        '2021-04-11 00:56:14', 0);
INSERT INTO `board`
VALUES (5, 10000, '系统搭建完成！', '2021-04-11 01:04:54', 1);
INSERT INTO `board`
VALUES (6, 10000, '哈哈哈哈哈哈哈哈或或或或或', '2021-04-11 01:11:54', 1);

-- ----------------------------
-- Table structure for current
-- ----------------------------
DROP TABLE IF EXISTS `current`;
CREATE TABLE `current`
(
    `id`               int UNSIGNED                                                  NOT NULL AUTO_INCREMENT,
    `user_id`          int UNSIGNED                                                  NOT NULL,
    `used`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `last_update_time` datetime                                                      NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `id_user_id` (`user_id`) USING BTREE,
    CONSTRAINT `id_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of current
-- ----------------------------
INSERT INTO `current`
VALUES (1, 20001, '1.54', '2021-04-06 17:23:05');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`
(
    `id`      int UNSIGNED                                                  NOT NULL AUTO_INCREMENT,
    `user_id` int UNSIGNED                                                  NOT NULL,
    `used`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `date`    date                                                          NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `id_user_id2` (`user_id`) USING BTREE,
    CONSTRAINT `id_user_id2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history`
VALUES (1, 20001, '12.54', '2021-03-27');
INSERT INTO `history`
VALUES (2, 20001, '13.22', '2021-03-28');
INSERT INTO `history`
VALUES (3, 20001, '34.41', '2021-03-29');
INSERT INTO `history`
VALUES (4, 20001, '54.31', '2021-03-30');
INSERT INTO `history`
VALUES (5, 20001, '23.4', '2021-03-31');
INSERT INTO `history`
VALUES (6, 20001, '2.1', '2021-04-01');
INSERT INTO `history`
VALUES (7, 20001, '5.2', '2021-04-02');

-- ----------------------------
-- Table structure for price
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price`
(
    `id`         int UNSIGNED                                                 NOT NULL AUTO_INCREMENT,
    `date`       datetime                                                     NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `price`      varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `elect_type` tinyint                                                      NULL DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of price
-- ----------------------------
INSERT INTO `price`
VALUES (1, '2021-02-03 16:02:38', '0.45', 0);
INSERT INTO `price`
VALUES (2, '2021-02-19 16:02:57', '1.04', 1);
INSERT INTO `price`
VALUES (3, '2021-04-10 23:17:57', '0.46', 0);
INSERT INTO `price`
VALUES (5, '2021-04-10 23:18:10', '1.03', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`            int UNSIGNED                                          NOT NULL AUTO_INCREMENT COMMENT '账号',
    `name`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '姓名',
    `phone`         text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '手机号码',
    `gender`        text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '性别',
    `address`       text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '地址',
    `elect_type`    tinyint UNSIGNED                                      NOT NULL DEFAULT 0 COMMENT '商用1/民用0',
    `id_number`     text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '身份证号',
    `password`      text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
    `is_admin`      tinyint UNSIGNED                                      NOT NULL DEFAULT 0 COMMENT '是否管理员',
    `register_time` datetime                                              NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 20007
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (10000, 'admin', '13388665566', 'male', 'no addr', 0, NULL, '123456', 1, '2021-04-02 21:59:32');
INSERT INTO `user`
VALUES (20001, '李四', '18822424756', '女', '安徽省合肥市蜀山区蜀南庭苑1栋101', 0, '340102198912131538', '123456', 0,
        '2021-04-05 18:43:56');
INSERT INTO `user`
VALUES (20002, '张三', '13344334333', '男', '无地址', 0, '340102198709121314', '123456', 0, '2021-04-04 21:26:55');
INSERT INTO `user`
VALUES (20004, '王五', '1887548459', '女', 'house1', 0, '123', '123456', 0, '2021-04-09 21:15:29');
INSERT INTO `user`
VALUES (20005, 'CHEN LEIMENG', '1232131232131', '男', 'House next by the lake', 0, 'admin', 'admin', 0,
        '2021-04-09 21:16:25');
INSERT INTO `user`
VALUES (20006, 'CHEN LEIMENG', '13655885478', '女', '2312312312', 0, '12312312312312312312', '123456', 0,
        '2021-04-09 21:19:33');

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`
(
    `id`           int UNSIGNED                                                  NOT NULL AUTO_INCREMENT,
    `user_id`      int UNSIGNED                                                  NULL DEFAULT NULL,
    `old_balance`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `operate`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `new_balance`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `operate_time` datetime                                                      NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `id_2` (`user_id`) USING BTREE,
    CONSTRAINT `id_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wallet
-- ----------------------------
INSERT INTO `wallet`
VALUES (1, 20001, '0', '充值_支付宝', '100', '2021-04-05 14:31:41');
INSERT INTO `wallet`
VALUES (2, 20001, '100', '年费', '99', '2021-04-05 14:31:27');
INSERT INTO `wallet`
VALUES (3, 20001, '99', '消费', '90.2', '2021-04-05 18:26:09');
INSERT INTO `wallet`
VALUES (4, 20001, '90.2', '消费', '90.1', '2021-04-05 18:26:35');
INSERT INTO `wallet`
VALUES (5, 20001, '90.1', '测试', '90.0', '2021-04-05 18:29:42');
INSERT INTO `wallet`
VALUES (6, 20001, '90.0', '测试', '89.9', '2021-04-05 18:29:44');
INSERT INTO `wallet`
VALUES (7, 20001, '89.9', '测试', '88.8', '2021-04-05 18:29:46');
INSERT INTO `wallet`
VALUES (8, 20001, '89.8', '测试', '88.7', '2021-04-05 18:29:48');
INSERT INTO `wallet`
VALUES (9, 20001, '89.7', '测试', '88.6', '2021-04-05 18:29:52');
INSERT INTO `wallet`
VALUES (10, 20001, '89.6', '测试', '88.5', '2021-04-05 18:29:54');
INSERT INTO `wallet`
VALUES (11, 20001, '89.5', '测试', '88.4', '2021-04-05 18:29:57');
INSERT INTO `wallet`
VALUES (12, 20001, '89.4', '测试', '88.3', '2021-04-05 18:29:59');

SET FOREIGN_KEY_CHECKS = 1;
