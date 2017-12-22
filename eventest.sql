/*
Navicat MySQL Data Transfer

Source Server         : 47.100.0.82
Source Server Version : 50633
Source Host           : 47.100.0.82:3306
Source Database       : eventest

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-12-22 18:30:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_auth`;
CREATE TABLE `sys_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `auth_name` varchar(200) DEFAULT NULL COMMENT '权限名称',
  `auth_tag` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `auth_code` varchar(500) DEFAULT NULL COMMENT '权限代码',
  `autd_desc` varchar(500) DEFAULT NULL COMMENT '权限描述',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_auth
-- ----------------------------
INSERT INTO `sys_auth` VALUES ('1', '系统管理菜单权限', null, null, null, '1', null, null);
INSERT INTO `sys_auth` VALUES ('2', 'auth2', null, null, null, '1', null, null);
INSERT INTO `sys_auth` VALUES ('3', 'auth3', null, null, null, '1', null, null);
INSERT INTO `sys_auth` VALUES ('4', 'auth4', null, null, null, '1', null, null);
INSERT INTO `sys_auth` VALUES ('5', 'auth5', null, null, null, '1', '2017-12-11 17:41:00', '2017-12-11 17:41:04');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(200) DEFAULT NULL COMMENT '部门名称',
  `dept_leader_id` bigint(20) DEFAULT NULL COMMENT '部门主管id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `operate_user_id` bigint(20) DEFAULT NULL COMMENT '操作人id',
  `opreate_ip` varchar(200) DEFAULT NULL COMMENT '操作IP地址',
  `log_content` varchar(500) DEFAULT NULL COMMENT '日志内容',
  `log_type` int(10) DEFAULT NULL COMMENT '操作类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `menu_name` varchar(200) DEFAULT NULL COMMENT '菜单名称',
  `menu_desc` varchar(500) DEFAULT NULL COMMENT '菜单描述',
  `menu_icon` varchar(200) DEFAULT NULL COMMENT '图标',
  `menu_url` varchar(500) DEFAULT NULL COMMENT '菜单地址',
  `menu_type` int(10) DEFAULT NULL COMMENT '菜单类型',
  `menu_status` int(10) DEFAULT NULL COMMENT '状态',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级菜单',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `sort_id` int(10) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '系统管理', 'glyphicon glyphicon-cog', '', '1', '1', '0', '1', null, '2017-11-11 13:56:23', '2017-12-19 16:44:56');
INSERT INTO `sys_menu` VALUES ('2', '管理员管理', '管理员管理', 'glyphicon glyphicon-user', '/sysUser/page/user_menage', '1', '1', '1', '1', null, '2017-11-11 13:56:19', '2017-12-21 15:43:59');
INSERT INTO `sys_menu` VALUES ('3', '菜单管理', '菜单管理', 'glyphicon glyphicon-align-left', '/sysMenu/page/menu_manage', '1', '1', '1', '1', null, '2017-11-11 13:56:19', '2017-12-21 15:41:56');
INSERT INTO `sys_menu` VALUES ('4', '角色管理', '角色管理', 'list-alt\r\nglyphicon glyphicon-education', '/sysRole/page/role_manage', '1', '1', '1', '1', null, '2017-11-11 13:56:02', '2017-12-21 15:44:01');
INSERT INTO `sys_menu` VALUES ('5', 'SQL监控', 'SQL监控', 'list-alt\r\nglyphicon glyphicon-cloud', '/druid/page', '1', '1', '1', '1', null, '2017-11-11 13:56:02', '2017-12-21 15:44:00');
INSERT INTO `sys_menu` VALUES ('6', '一级菜单2', '测试菜单', 'list-alt\r\nglyphicon glyphicon-cloud', '/test/page', '2', '1', '0', '2', null, '2017-11-11 13:56:02', '2017-12-15 18:26:33');
INSERT INTO `sys_menu` VALUES ('7', '二级级菜单1', '二级级菜单111', '#television', '/test/page', '2', null, null, null, null, null, '2017-12-19 16:01:50');
INSERT INTO `sys_menu` VALUES ('8', '二级级菜单2', '二级级菜单2', 'list-alt\r\nglyphicon glyphicon-cloud', '/test/page', '2', '1', '1', '1', null, '2017-11-11 13:56:02', '2017-12-22 16:17:04');
INSERT INTO `sys_menu` VALUES ('9', '三级级菜单1', '三级级菜单1', 'list-alt\r\nglyphicon glyphicon-cloud', '/test/page', '2', '1', '7', '2', null, '2017-11-11 13:56:02', '2017-12-19 10:55:08');
INSERT INTO `sys_menu` VALUES ('10', '2323', '2332', '23', '2323', '2', '1', '1', '2', null, '2017-12-15 15:25:55', '2017-12-15 18:33:17');
INSERT INTO `sys_menu` VALUES ('11', '三级测试菜单2', '三级测试菜单2', 'icon32', '/test/page/testPage32', '2', '1', '7', '1', null, '2017-12-15 15:26:44', '2017-12-15 15:26:44');
INSERT INTO `sys_menu` VALUES ('12', '2323', '23233', '2323', '233223', '2', '1', '7', '1', null, '2017-12-15 15:27:29', '2017-12-15 15:27:29');
INSERT INTO `sys_menu` VALUES ('13', '111', '111', '111', '111', '2', '1', '8', '2', null, '2017-12-15 15:28:48', '2017-12-19 12:51:55');
INSERT INTO `sys_menu` VALUES ('14', '222111', '222', '222', '222', '2', null, null, null, null, null, '2017-12-19 16:02:25');
INSERT INTO `sys_menu` VALUES ('15', '3331', '3331', '3331', '3331', '2', '1', '8', '2', null, '2017-12-15 15:45:07', '2017-12-19 16:10:17');
INSERT INTO `sys_menu` VALUES ('16', '444', '444', '444', '444', '2', '1', '8', '2', null, '2017-12-15 15:50:13', '2017-12-15 18:33:53');
INSERT INTO `sys_menu` VALUES ('17', '555', '5555', '555', '555', '2', '1', '8', '2', null, '2017-12-15 15:53:30', '2017-12-20 17:28:51');
INSERT INTO `sys_menu` VALUES ('18', '32', '32', '23', '23', '2', '1', '8', '1', null, '2017-12-15 15:53:43', '2017-12-15 15:53:43');
INSERT INTO `sys_menu` VALUES ('19', '4411', '2323', '423', '23', '2', '1', '8', '2', null, '2017-12-15 15:53:52', '2017-12-15 18:33:24');
INSERT INTO `sys_menu` VALUES ('20', '1122', '1122', '1122', '1122', '2', '1', '10', '2', null, '2017-12-15 15:58:00', '2017-12-15 18:33:04');
INSERT INTO `sys_menu` VALUES ('21', '233', '233', '233', '233', '2', '1', '10', '2', null, '2017-12-15 16:01:16', '2017-12-15 18:33:11');
INSERT INTO `sys_menu` VALUES ('22', 'aaa', '3223', '23', '32', '2', '1', '7', '1', null, '2017-12-19 16:00:38', '2017-12-19 16:00:38');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `role_status` int(10) DEFAULT NULL COMMENT '状态',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'isAdmin', '1', '1', null, null);
INSERT INTO `sys_role` VALUES ('2', 'nomal', 'isNomal', '1', '2', null, null);
INSERT INTO `sys_role` VALUES ('3', 'role3', 'isRole3', '2', '2', '2017-12-14 18:08:47', '2017-12-14 18:08:50');
INSERT INTO `sys_role` VALUES ('4', 'role4', 'isRole4', '2', '2', '2017-12-14 18:08:47', '2017-12-14 18:08:50');
INSERT INTO `sys_role` VALUES ('5', '测试', '测试角色', '1', '1', '2017-12-20 10:33:45', '2017-12-20 10:33:45');
INSERT INTO `sys_role` VALUES ('6', '运维', '运维角色', '1', '1', '2017-12-20 10:35:01', '2017-12-20 10:35:01');
INSERT INTO `sys_role` VALUES ('7', 'aaa', 'aaadesc', '1', '2', '2017-12-20 10:35:52', '2017-12-20 10:35:52');
INSERT INTO `sys_role` VALUES ('8', '运营', '运营角色', '2', '1', '2017-12-20 10:39:13', '2017-12-20 10:39:13');
INSERT INTO `sys_role` VALUES ('9', '搬砖工', '搬砖工角色', '1', '1', '2017-12-20 10:42:06', '2017-12-20 10:42:06');
INSERT INTO `sys_role` VALUES ('10', '策划1', '策划角色1', '1', '2', '2017-12-20 10:42:06', '2017-12-22 16:20:10');
INSERT INTO `sys_role` VALUES ('11', 'sss', 'sssdesc', '1', '2', '2017-12-20 13:57:01', '2017-12-20 13:57:01');
INSERT INTO `sys_role` VALUES ('12', '111', '111', '1', '2', '2017-12-20 14:30:31', '2017-12-20 14:30:31');

-- ----------------------------
-- Table structure for sys_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_auth`;
CREATE TABLE `sys_role_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  `auth_id` bigint(20) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_auth
-- ----------------------------
INSERT INTO `sys_role_auth` VALUES ('1', '1', '1');
INSERT INTO `sys_role_auth` VALUES ('2', '1', '2');
INSERT INTO `sys_role_auth` VALUES ('3', '2', '3');
INSERT INTO `sys_role_auth` VALUES ('4', '1', '3');
INSERT INTO `sys_role_auth` VALUES ('5', '1', '4');
INSERT INTO `sys_role_auth` VALUES ('6', '1', '5');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('4', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('5', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('6', '1', '6');

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
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门编号',
  `user_status` int(10) DEFAULT NULL COMMENT '状态',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `last_login_ip` varchar(200) DEFAULT NULL COMMENT '上次登陆ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123', null, 'ADMIN', 'admin@qq.com', null, '1', '15112341234', null, '1', '1', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('2', 'even', '123', null, 'EVEN', 'even@qq.com', null, '2', '15212345678', null, '2', '1', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('3', 'user1', '123', null, 'EVEN', 'user1@qq.com', null, '2', '15212345678', null, null, '1', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('4', 'user2', '123', null, 'EVEN', 'user2@qq.com', null, '1', '15212345678', null, null, '1', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('5', 'user3', '123', '', 'EVEN', 'user3@qq.com', '', '1', '15212345678', null, null, '1', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('6', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', null, '2', null, null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('7', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', null, '2', null, null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('8', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', null, '2', null, null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('9', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', null, '2', null, null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('10', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', null, '2', null, null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('11', 'even', '123', '', 'EVEN', 'even@qq.com', '', '2', '15212345678', null, '2', null, null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('12', 'user3', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('13', 'user3', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('14', '1111111111111', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('15', '222221', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('16', 'aaaa', '123', null, 'EVEN', 'aaaa@qq.com', null, '2', '15212345678', null, '1', '2', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('19', 'xxyy', '123', null, 'EVEN', 'xxyy@qq.com', null, '2', '15212345678', null, '1', '2', '2017-11-08 21:22:47', '2017-11-08 21:22:47', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('20', 'tttt', '123', null, 'EVEN', 'tttt@qq.com', null, '2', '15212345678', null, '1', '2', '2017-11-08 21:27:45', '2017-11-08 21:27:45', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('21', '1111111111111', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', '2017-11-08 21:34:30', '2017-11-08 21:34:30', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('22', '3333', '123', null, 'EVEN', '123@qq.com', null, '2', '15212345678', null, '1', '2', '2017-11-08 21:39:19', '2017-11-08 21:39:19', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('23', '2333', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', '2017-11-08 21:43:08', '2017-11-08 21:43:08', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('24', '32323331', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', '2017-11-08 21:43:43', '2017-11-08 21:43:43', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('25', '2222111', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', '2017-11-08 21:44:23', '2017-11-08 21:44:23', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('26', 'jobs', '123', null, 'EVEN', 'jobs@qq.com', null, '2', '15212345678', null, '1', '2', '2017-11-08 21:45:17', '2017-11-08 21:45:17', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('27', 'aaaa', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', '2017-11-08 22:51:47', '2017-11-08 22:51:47', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('28', 'bbbb', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '1', '2017-11-08 22:52:04', '2017-11-08 22:52:04', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('29', 'cccc', '123', null, 'EVEN', '123@qq.com', null, '2', '15212345678', null, '1', '1', '2017-11-08 22:52:19', '2017-11-08 22:52:19', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('30', 'dddd', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '1', '2017-11-08 22:52:32', '2017-11-08 22:52:32', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('31', '1111', '123', null, 'EVEN', '123Q@qq.com', null, '1', '15212345678', null, '1', '1', '2017-11-08 22:52:52', '2017-11-08 22:52:52', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('32', '2233', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '1', '2017-11-08 22:53:12', '2017-11-08 22:53:12', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('33', '4444', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '1', '2017-11-08 22:53:24', '2017-11-08 22:53:24', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('34', '5555', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '1', '2017-11-08 22:53:38', '2017-11-08 22:53:38', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('35', '6666', '123', null, 'EVEN', '123@qq.com', null, '2', '15212345678', null, '1', '1', '2017-11-08 22:53:58', '2017-11-08 22:53:58', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('36', '8888', '123', null, 'EVEN', '123@qq.com', null, '1', '15212345678', null, '1', '2', '2017-11-08 22:54:19', '2017-11-08 22:54:19', '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('38', 'test222', null, null, null, 'test222@qq.com', null, null, null, null, '1', '1', '2017-12-22 17:28:34', '2017-12-22 17:28:34', null, null);

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
