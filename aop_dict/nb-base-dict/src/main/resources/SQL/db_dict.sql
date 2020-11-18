/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : db_dict

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 18/11/2020 10:12:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典编码',
  `dict_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `is_del` tinyint(4) NULL DEFAULT NULL COMMENT '是否删除:0否1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, 'sex', '性别', 0);
INSERT INTO `sys_dict` VALUES (2, 'user_status', '用户状态', 0);
INSERT INTO `sys_dict` VALUES (3, 'user_type', '用户类型', 0);
INSERT INTO `sys_dict` VALUES (4, 'teacher_title', '老师职称', 0);

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_id` int(11) NULL DEFAULT NULL COMMENT '字典表id',
  `item_text` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项文本',
  `item_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项值',
  `sort_no` int(11) NULL DEFAULT NULL COMMENT '排序',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '是否启动',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES (1, 1, '未知', '0', 1, 1);
INSERT INTO `sys_dict_item` VALUES (2, 1, '男', '1', 2, 1);
INSERT INTO `sys_dict_item` VALUES (3, 1, '女', '2', 3, 1);
INSERT INTO `sys_dict_item` VALUES (4, 2, '启用', '1', 1, 1);
INSERT INTO `sys_dict_item` VALUES (5, 2, '禁用', '0', 2, 1);
INSERT INTO `sys_dict_item` VALUES (6, 3, '老师', '1', 1, 1);
INSERT INTO `sys_dict_item` VALUES (7, 3, '学生', '2', 2, 1);
INSERT INTO `sys_dict_item` VALUES (8, 3, '管理员', '3', 3, 1);
INSERT INTO `sys_dict_item` VALUES (9, 4, '助教', '1', 1, 1);
INSERT INTO `sys_dict_item` VALUES (10, 4, '讲师', '2', 2, 1);
INSERT INTO `sys_dict_item` VALUES (11, 4, '副教授', '3', 3, 1);
INSERT INTO `sys_dict_item` VALUES (12, 4, '教授', '4', 4, 1);

-- ----------------------------
-- Table structure for sys_teacher
-- ----------------------------
DROP TABLE IF EXISTS `sys_teacher`;
CREATE TABLE `sys_teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `teacher_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师名称',
  `title` tinyint(4) NULL DEFAULT 1 COMMENT '职称(引用字典表)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_teacher
-- ----------------------------
INSERT INTO `sys_teacher` VALUES (1, '牛贝', 2);
INSERT INTO `sys_teacher` VALUES (2, '西决', 1);
INSERT INTO `sys_teacher` VALUES (3, '石竹', 3);
INSERT INTO `sys_teacher` VALUES (4, '樟树鱼', 4);
INSERT INTO `sys_teacher` VALUES (5, '小羊', 3);
INSERT INTO `sys_teacher` VALUES (6, '小羊', 3);
INSERT INTO `sys_teacher` VALUES (7, '小羊', 3);
INSERT INTO `sys_teacher` VALUES (8, '小羊', 3);
INSERT INTO `sys_teacher` VALUES (9, '小羊', 3);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `sex` tinyint(1) NULL DEFAULT 0 COMMENT '性别(0-默认未知,1-男,2-女)',
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '性别(1-正常,2-冻结)',
  `user_type` tinyint(4) NULL DEFAULT NULL COMMENT '用户类型：1-老师；2-学生；3-管理员',
  `allow_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '允许性别(多个逗号分隔)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_user_name`(`username`) USING BTREE,
  INDEX `index_user_status`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (6, '张三', 0, 'asd@qq.com', 1, 2, '1,2');
INSERT INTO `sys_user` VALUES (7, '李四', 1, 'dsasd@qq.com', 1, 2, '1,');
INSERT INTO `sys_user` VALUES (8, '张老师', 0, 'gfdsa@qq.com', 1, 1, '1');
INSERT INTO `sys_user` VALUES (9, 'admin后台', 1, 'ttrrr@qq.com', 0, 3, '1,2');

SET FOREIGN_KEY_CHECKS = 1;
