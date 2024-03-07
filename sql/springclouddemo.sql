/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : springclouddemo

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 07/03/2024 17:29:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '苹果手机');
INSERT INTO `product` VALUES (2, '华为手机');
INSERT INTO `product` VALUES (4, 'meizu');
INSERT INTO `product` VALUES (6, 'xiaomi');
INSERT INTO `product` VALUES (7, 'xiaomi');
INSERT INTO `product` VALUES (8, 'xiaomi');
INSERT INTO `product` VALUES (9, 'xiaomi');
INSERT INTO `product` VALUES (10, 'xiaomi');
INSERT INTO `product` VALUES (11, 'xiaomi');
INSERT INTO `product` VALUES (12, 'xiaomi');
INSERT INTO `product` VALUES (13, 'xiaomi');
INSERT INTO `product` VALUES (14, 'xiaomi');
INSERT INTO `product` VALUES (15, 'xiaomi');
INSERT INTO `product` VALUES (16, 'xiaomi');
INSERT INTO `product` VALUES (17, 'xiaomi');
INSERT INTO `product` VALUES (18, 'xiaomi');
INSERT INTO `product` VALUES (19, 'xiaomi');
INSERT INTO `product` VALUES (20, 'xiaomi');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user_1', 'user_1');
INSERT INTO `user` VALUES (2, 'editor_1', 'editor_1');
INSERT INTO `user` VALUES (3, 'adm_1', 'adm_1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 'USER');
INSERT INTO `user_role` VALUES (2, 2, 'EDITOR');

SET FOREIGN_KEY_CHECKS = 1;
