/*
Navicat MySQL Data Transfer

Source Server         : localDB
Source Server Version : 50713
Source Host           : 127.0.0.1:3306
Source Database       : eventest

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-11-08 22:57:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_auth`;
CREATE TABLE `sys_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `auth_name` varchar(200) DEFAULT NULL COMMENT '权限名称',
  `auth_desc` varchar(500) DEFAULT NULL COMMENT '权限描述',
  `auth_icon` varchar(200) DEFAULT NULL COMMENT '图标',
  `auth_status` int(10) DEFAULT NULL COMMENT '状态',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级权限',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `sort_id` int(10) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_auth
-- ----------------------------
INSERT INTO `sys_auth` VALUES ('1', 'auth1', 'isAuth1', null, null, null, null, null, null, null);
INSERT INTO `sys_auth` VALUES ('2', 'auth2', 'isAuth2', null, null, null, null, null, null, null);
INSERT INTO `sys_auth` VALUES ('3', 'auth3', 'isAuth3', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `role_status` int(10) DEFAULT NULL COMMENT '状态',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级角色',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'isAdmin', '1', null, '1', null, null);
INSERT INTO `sys_role` VALUES ('2', 'nomal', 'isNomal', '2', null, '1', null, null);

-- ----------------------------
-- Table structure for sys_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_auth`;
CREATE TABLE `sys_role_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  `auth_id` bigint(20) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_auth
-- ----------------------------
INSERT INTO `sys_role_auth` VALUES ('1', '1', '1');
INSERT INTO `sys_role_auth` VALUES ('2', '1', '2');
INSERT INTO `sys_role_auth` VALUES ('3', '2', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `user_pwd` varchar(200) DEFAULT NULL COMMENT '用户密码',
  `pwd_salt` varchar(200) DEFAULT NULL COMMENT '盐值',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实名称',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `user_photo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别',
  `user_mobile` varchar(20) DEFAULT NULL COMMENT '用户电话',
  `user_status` int(10) DEFAULT NULL COMMENT '状态',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123', null, 'ADMIN', 'admin@qq.com', null, '1', '15112341234', '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2', 'even', '123', null, 'EVEN', 'even@qq.com', null, '2', '15212345678', '2', '2', null, null);
INSERT INTO `sys_user` VALUES ('3', 'user1', '123', null, null, 'user1@qq.com', null, '2', null, null, '2', null, null);
INSERT INTO `sys_user` VALUES ('4', 'user2', '123', null, null, 'user2@qq.com', null, '1', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('5', 'user3', '123', '', '', 'user3@qq.com', '', '1', '', null, null, null, null);
INSERT INTO `sys_user` VALUES ('6', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', '2', null, null, null);
INSERT INTO `sys_user` VALUES ('7', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', '2', null, null, null);
INSERT INTO `sys_user` VALUES ('8', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', '2', null, null, null);
INSERT INTO `sys_user` VALUES ('9', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', '2', null, null, null);
INSERT INTO `sys_user` VALUES ('10', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', '2', null, null, null);
INSERT INTO `sys_user` VALUES ('11', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', '2', null, null, null);
INSERT INTO `sys_user` VALUES ('12', 'user3', '123', null, null, '123@qq.com', null, '1', null, '1', '2', null, null);
INSERT INTO `sys_user` VALUES ('13', 'user3', '123', null, null, '123@qq.com', null, '1', null, '1', '2', null, null);
INSERT INTO `sys_user` VALUES ('14', '1111111111111', '123', null, null, '123@qq.com', null, '1', null, '1', '2', null, null);
INSERT INTO `sys_user` VALUES ('15', '222221', '123', null, null, '123@qq.com', null, '1', null, '1', '2', null, null);
INSERT INTO `sys_user` VALUES ('16', 'aaaa', '123', null, null, 'aaaa@qq.com', null, '2', null, '1', '2', null, null);
INSERT INTO `sys_user` VALUES ('17', null, null, null, null, null, null, null, null, '1', '2', '2017-11-08 21:17:26', '2017-11-08 21:17:26');
INSERT INTO `sys_user` VALUES ('18', null, null, null, null, null, null, null, null, '1', '2', '2017-11-08 21:21:08', '2017-11-08 21:21:08');
INSERT INTO `sys_user` VALUES ('19', 'xxyy', '123', null, null, 'xxyy@qq.com', null, '2', null, '1', '2', '2017-11-08 21:22:47', '2017-11-08 21:22:47');
INSERT INTO `sys_user` VALUES ('20', 'tttt', '123', null, null, 'tttt@qq.com', null, '2', null, '1', '2', '2017-11-08 21:27:45', '2017-11-08 21:27:45');
INSERT INTO `sys_user` VALUES ('21', '1111111111111', '123', null, null, '123@qq.com', null, '1', null, '1', '2', '2017-11-08 21:34:30', '2017-11-08 21:34:30');
INSERT INTO `sys_user` VALUES ('22', '3333', '123', null, null, '123@qq.com', null, '2', null, '1', '2', '2017-11-08 21:39:19', '2017-11-08 21:39:19');
INSERT INTO `sys_user` VALUES ('23', '2333', '123', null, null, '123@qq.com', null, '1', null, '1', '2', '2017-11-08 21:43:08', '2017-11-08 21:43:08');
INSERT INTO `sys_user` VALUES ('24', '32323331', '123', null, null, '123@qq.com', null, '1', null, '1', '1', '2017-11-08 21:43:43', '2017-11-08 21:43:43');
INSERT INTO `sys_user` VALUES ('25', '2222111', '123', null, null, '123@qq.com', null, '1', null, '1', '1', '2017-11-08 21:44:23', '2017-11-08 21:44:23');
INSERT INTO `sys_user` VALUES ('26', 'jobs', '123', null, null, 'jobs@qq.com', null, '2', null, '1', '2', '2017-11-08 21:45:17', '2017-11-08 21:45:17');
INSERT INTO `sys_user` VALUES ('27', 'aaaa', '123', null, null, '123@qq.com', null, '1', null, '1', '1', '2017-11-08 22:51:47', '2017-11-08 22:51:47');
INSERT INTO `sys_user` VALUES ('28', 'bbbb', '123', null, null, '123@qq.com', null, '1', null, '1', '1', '2017-11-08 22:52:04', '2017-11-08 22:52:04');
INSERT INTO `sys_user` VALUES ('29', 'cccc', '123', null, null, '123@qq.com', null, '2', null, '1', '1', '2017-11-08 22:52:19', '2017-11-08 22:52:19');
INSERT INTO `sys_user` VALUES ('30', 'dddd', '123', null, null, '123@qq.com', null, '1', null, '1', '1', '2017-11-08 22:52:32', '2017-11-08 22:52:32');
INSERT INTO `sys_user` VALUES ('31', '1111', '123', null, null, '123Q@qq.com', null, '1', null, '1', '1', '2017-11-08 22:52:52', '2017-11-08 22:52:52');
INSERT INTO `sys_user` VALUES ('32', '2233', '123', null, null, '123@qq.com', null, '1', null, '1', '1', '2017-11-08 22:53:12', '2017-11-08 22:53:12');
INSERT INTO `sys_user` VALUES ('33', '4444', '123', null, null, '123@qq.com', null, '1', null, '1', '1', '2017-11-08 22:53:24', '2017-11-08 22:53:24');
INSERT INTO `sys_user` VALUES ('34', '5555', '123', null, null, '123@qq.com', null, '1', null, '1', '1', '2017-11-08 22:53:38', '2017-11-08 22:53:38');
INSERT INTO `sys_user` VALUES ('35', '6666', '123', null, null, '123@qq.com', null, '2', null, '1', '1', '2017-11-08 22:53:58', '2017-11-08 22:53:58');
INSERT INTO `sys_user` VALUES ('36', '8888', '123', null, null, '123@qq.com', null, '1', null, '1', '2', '2017-11-08 22:54:19', '2017-11-08 22:54:19');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
