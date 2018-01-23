/*
Navicat MySQL Data Transfer

Source Server         : 47.100.0.82
Source Server Version : 50633
Source Host           : 47.100.0.82:3306
Source Database       : eventest

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2018-01-19 10:11:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for day_data
-- ----------------------------
DROP TABLE IF EXISTS `day_data`;
CREATE TABLE `day_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `day` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of day_data
-- ----------------------------
INSERT INTO `day_data` VALUES ('1', '1', '2018-01-01');
INSERT INTO `day_data` VALUES ('2', '2', '2018-01-01');
INSERT INTO `day_data` VALUES ('3', '3', '2018-01-01');
INSERT INTO `day_data` VALUES ('4', '4', '2018-01-02');
INSERT INTO `day_data` VALUES ('5', '5', '2018-01-02');
INSERT INTO `day_data` VALUES ('6', '6', '2018-01-03');

-- ----------------------------
-- Table structure for sys_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_auth`;
CREATE TABLE `sys_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `auth_name` varchar(200) DEFAULT NULL COMMENT '权限名称',
  `auth_desc` varchar(500) DEFAULT NULL COMMENT '权限描述',
  `perms` varchar(200) DEFAULT NULL COMMENT '权限代码',
  `icon` varchar(200) DEFAULT NULL COMMENT '图标',
  `link_url` varchar(500) DEFAULT NULL COMMENT '链接地址',
  `type` int(10) DEFAULT NULL COMMENT '权限类型（1:目录 2:菜单 3:按钮）',
  `status` int(10) DEFAULT NULL COMMENT '状态',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `sort_no` int(10) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_auth
-- ----------------------------
INSERT INTO `sys_auth` VALUES ('1', '系统管理', '系统管理设置', 'system:manage', null, '', '1', '1', '0', '1', '1', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('2', '权限管理', '管理系统菜单', 'system:menu:manage', null, '/sysAuth/page', '2', '1', '1', '1', '2', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('3', '角色管理', '管理系统角色', 'system:role:manage', null, '/sysRole/page', '2', '1', '1', '1', '2', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('4', '用户管理', '管理系统用户', 'system:user:manage', null, '/sysUser/page', '2', '1', '1', '1', '2', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('5', 'SQL监控', '实时监控sql情况', 'system:sql:view', null, '/druid/sql', '2', '1', '1', '1', '2', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('6', '一级测试菜单2', '一级测试菜单2', 'test:menu', '', '/test/menu1', '2', '1', '0', '1', '1', '2017-12-11 17:41:00', '2018-01-11 16:29:36');
INSERT INTO `sys_auth` VALUES ('7', '添加角色', '添加角色按钮', 'role:add', null, '', '3', '1', '3', '1', '3', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('8', '添加权限', '添加权限按钮', 'auth:add', null, '', '3', '1', '2', '1', '3', '2018-01-03 16:27:45', '2018-01-03 16:27:47');
INSERT INTO `sys_auth` VALUES ('9', '编辑权限', '编辑权限按钮', 'auth:edit', '', '', '3', '1', '2', '1', '3', '2018-01-03 16:27:45', '2018-01-03 16:27:47');
INSERT INTO `sys_auth` VALUES ('10', '删除权限', '删除权限按钮', 'auth:delete', '', '', '3', '1', '2', '1', '3', '2018-01-03 16:27:45', '2018-01-03 16:27:47');
INSERT INTO `sys_auth` VALUES ('11', '编辑角色', '编辑角色按钮', 'role:edit', null, null, '3', '1', '3', '1', '3', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('12', '删除角色', '删除角色按钮', 'role:delete', null, null, '3', '1', '3', '1', '2', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('74', '无权限测试菜单', '2323', '32', '', null, '2', '1', '0', '2', null, '2018-01-12 12:36:39', '2018-01-12 12:57:30');
INSERT INTO `sys_auth` VALUES ('75', '3223', '232', '233', '23', null, '1', '1', '0', '1', null, '2018-01-12 13:58:29', '2018-01-12 13:58:29');
INSERT INTO `sys_auth` VALUES ('76', '32', null, '23', '23', null, '1', '1', '0', '1', null, '2018-01-12 13:58:34', '2018-01-12 13:58:34');
INSERT INTO `sys_auth` VALUES ('77', '32', null, '43', '43', null, '1', '1', '0', '1', null, '2018-01-12 13:58:37', '2018-01-12 13:58:37');
INSERT INTO `sys_auth` VALUES ('78', '2435', null, '54', '45', null, '1', '1', '0', '1', null, '2018-01-12 13:58:44', '2018-01-12 13:58:44');
INSERT INTO `sys_auth` VALUES ('79', '23', null, '23', null, null, '1', '1', '0', '1', null, '2018-01-12 13:59:02', '2018-01-12 13:59:02');
INSERT INTO `sys_auth` VALUES ('80', '34', null, '34', null, null, '1', '1', '0', '1', null, '2018-01-12 13:59:06', '2018-01-12 13:59:06');
INSERT INTO `sys_auth` VALUES ('81', '4334', null, '434', null, null, '2', '1', '0', '2', null, '2018-01-12 13:59:11', '2018-01-15 16:58:57');
INSERT INTO `sys_auth` VALUES ('82', '4334', null, '3434', null, null, '2', '1', '0', '1', null, '2018-01-12 13:59:18', '2018-01-12 13:59:18');
INSERT INTO `sys_auth` VALUES ('83', '43', null, '54', null, null, '1', '1', '0', '1', null, '2018-01-12 13:59:35', '2018-01-12 13:59:35');
INSERT INTO `sys_auth` VALUES ('84', '54', null, '54', null, null, '1', '1', '0', '1', null, '2018-01-12 13:59:39', '2018-01-12 13:59:39');
INSERT INTO `sys_auth` VALUES ('85', '54', null, '5445', null, null, '2', '1', '81', '2', null, '2018-01-12 13:59:46', '2018-01-15 17:00:34');
INSERT INTO `sys_auth` VALUES ('86', '5445', null, '5445', null, null, '2', '1', '81', '1', null, '2018-01-12 14:00:03', '2018-01-12 14:00:03');
INSERT INTO `sys_auth` VALUES ('87', '23', null, '2323', '2323', null, '2', '1', '81', '2', null, '2018-01-12 14:00:12', '2018-01-15 17:00:29');
INSERT INTO `sys_auth` VALUES ('88', '32', null, '2323', null, null, '1', '1', '83', '1', null, '2018-01-12 14:00:19', '2018-01-12 14:00:19');
INSERT INTO `sys_auth` VALUES ('89', '3434', null, '432', null, null, '1', '1', '83', '1', null, '2018-01-12 14:00:26', '2018-01-12 14:00:26');
INSERT INTO `sys_auth` VALUES ('90', '2323', null, '242', null, null, '1', '1', '88', '1', null, '2018-01-12 14:00:33', '2018-01-12 14:00:33');
INSERT INTO `sys_auth` VALUES ('91', '菜单授权', null, 'role:auth', null, null, '3', '1', '3', '1', null, '2018-01-15 16:28:16', '2018-01-15 16:28:16');
INSERT INTO `sys_auth` VALUES ('92', '添加用户', null, 'user:add', null, null, '3', '1', '4', '1', null, '2018-01-15 16:30:54', '2018-01-15 16:30:54');
INSERT INTO `sys_auth` VALUES ('93', '编辑用户', null, 'user:edit', null, null, '3', '1', '4', '1', null, '2018-01-15 16:31:14', '2018-01-15 16:31:14');
INSERT INTO `sys_auth` VALUES ('94', '删除用户', null, 'user:delete', null, null, '3', '1', '4', '1', null, '2018-01-15 16:31:42', '2018-01-15 16:31:42');
INSERT INTO `sys_auth` VALUES ('95', '设置角色', null, 'user:role', null, null, '3', '1', '4', '1', null, '2018-01-15 16:32:23', '2018-01-15 16:32:23');
INSERT INTO `sys_auth` VALUES ('96', 'test', null, 'test', null, null, '2', '1', '1', '1', null, '2018-01-15 16:35:33', '2018-01-15 16:35:33');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(200) DEFAULT NULL COMMENT '部门名称',
  `dept_manage_id` bigint(20) DEFAULT NULL COMMENT '部门主管id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
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
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `status` int(10) DEFAULT NULL COMMENT '状态',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'isAdmin', '1', null, '1', null, null);
INSERT INTO `sys_role` VALUES ('2', 'nomal', 'isNomal', '1', null, '2', null, null);
INSERT INTO `sys_role` VALUES ('3', 'role3', 'isRole3', '2', null, '2', '2017-12-14 18:08:47', '2017-12-14 18:08:50');
INSERT INTO `sys_role` VALUES ('4', 'role4', 'isRole4', '2', null, '2', '2017-12-14 18:08:47', '2017-12-14 18:08:50');
INSERT INTO `sys_role` VALUES ('5', '测试', '测试角色', '1', null, '1', '2017-12-20 10:33:45', '2017-12-20 10:33:45');
INSERT INTO `sys_role` VALUES ('6', '运维', '运维角色', '1', null, '1', '2017-12-20 10:35:01', '2017-12-20 10:35:01');
INSERT INTO `sys_role` VALUES ('7', 'aaa', 'aaadesc', '1', null, '2', '2017-12-20 10:35:52', '2017-12-20 10:35:52');
INSERT INTO `sys_role` VALUES ('8', '运营', '运营角色', '2', null, '1', '2017-12-20 10:39:13', '2017-12-20 10:39:13');
INSERT INTO `sys_role` VALUES ('9', '搬砖工', '搬砖工角色', '1', null, '1', '2017-12-20 10:42:06', '2017-12-20 10:42:06');
INSERT INTO `sys_role` VALUES ('10', '策划1', '策划角色1', '1', null, '2', '2017-12-20 10:42:06', '2017-12-22 16:20:10');
INSERT INTO `sys_role` VALUES ('11', 'sss', 'sssdesc', '1', null, '2', '2017-12-20 13:57:01', '2017-12-20 13:57:01');
INSERT INTO `sys_role` VALUES ('12', '111', '111', '1', null, '2', '2017-12-20 14:30:31', '2017-12-20 14:30:31');
INSERT INTO `sys_role` VALUES ('13', '2332', '3223', '1', null, '1', '2018-01-11 18:39:40', '2018-01-11 18:39:40');
INSERT INTO `sys_role` VALUES ('14', '2323', '2323', '2', null, '1', '2018-01-11 18:45:10', '2018-01-11 18:45:10');
INSERT INTO `sys_role` VALUES ('15', '111', '1212', '2', null, '1', '2018-01-11 18:45:19', '2018-01-11 18:45:19');
INSERT INTO `sys_role` VALUES ('16', '555', '555', '1', null, '1', '2018-01-12 09:29:06', '2018-01-12 09:29:06');
INSERT INTO `sys_role` VALUES ('17', '6661', '666', '1', null, '2', '2018-01-12 09:29:21', '2018-01-12 10:14:45');
INSERT INTO `sys_role` VALUES ('18', '2332', '2332', '1', null, '2', '2018-01-12 10:00:28', '2018-01-12 10:00:28');
INSERT INTO `sys_role` VALUES ('19', 'fefw', '23', '1', null, '2', '2018-01-12 11:23:15', '2018-01-12 11:23:15');
INSERT INTO `sys_role` VALUES ('20', 'fewqqqqqqqqqqqqqqqqq', 'eqf', '2', null, '2', '2018-01-12 11:23:41', '2018-01-12 11:23:47');
INSERT INTO `sys_role` VALUES ('21', '2323', '2323', '1', null, '2', '2018-01-12 15:02:55', '2018-01-12 15:02:55');
INSERT INTO `sys_role` VALUES ('22', '2323', '2323', '1', null, '2', '2018-01-12 15:03:05', '2018-01-12 15:03:05');
INSERT INTO `sys_role` VALUES ('23', '232', '323', '1', null, '2', '2018-01-12 15:18:16', '2018-01-12 15:18:16');
INSERT INTO `sys_role` VALUES ('24', '2323', '2332', '1', null, '2', '2018-01-12 15:50:39', '2018-01-12 15:50:39');
INSERT INTO `sys_role` VALUES ('25', '2323', '2323', '1', null, '2', '2018-01-12 15:50:44', '2018-01-12 15:50:44');
INSERT INTO `sys_role` VALUES ('26', '231112', '2323', '1', null, '2', '2018-01-12 15:51:53', '2018-01-15 11:05:42');
INSERT INTO `sys_role` VALUES ('27', 'huh', '23r', '1', null, '2', '2018-01-15 14:56:59', '2018-01-15 14:56:59');

-- ----------------------------
-- Table structure for sys_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_auth`;
CREATE TABLE `sys_role_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  `auth_id` bigint(20) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_auth
-- ----------------------------
INSERT INTO `sys_role_auth` VALUES ('14', '8', '81');
INSERT INTO `sys_role_auth` VALUES ('15', '8', '83');
INSERT INTO `sys_role_auth` VALUES ('16', '8', '85');
INSERT INTO `sys_role_auth` VALUES ('17', '8', '86');
INSERT INTO `sys_role_auth` VALUES ('18', '8', '87');
INSERT INTO `sys_role_auth` VALUES ('19', '8', '88');
INSERT INTO `sys_role_auth` VALUES ('20', '8', '89');
INSERT INTO `sys_role_auth` VALUES ('21', '8', '90');
INSERT INTO `sys_role_auth` VALUES ('22', '9', '75');
INSERT INTO `sys_role_auth` VALUES ('23', '9', '76');
INSERT INTO `sys_role_auth` VALUES ('24', '8', '78');
INSERT INTO `sys_role_auth` VALUES ('25', '8', '79');
INSERT INTO `sys_role_auth` VALUES ('26', '9', '75');
INSERT INTO `sys_role_auth` VALUES ('27', '9', '76');
INSERT INTO `sys_role_auth` VALUES ('28', '9', '79');
INSERT INTO `sys_role_auth` VALUES ('29', '9', '75');
INSERT INTO `sys_role_auth` VALUES ('30', '9', '76');
INSERT INTO `sys_role_auth` VALUES ('31', '16', '75');
INSERT INTO `sys_role_auth` VALUES ('32', '16', '76');
INSERT INTO `sys_role_auth` VALUES ('35', '21', '75');
INSERT INTO `sys_role_auth` VALUES ('36', '21', '76');
INSERT INTO `sys_role_auth` VALUES ('37', '21', '77');
INSERT INTO `sys_role_auth` VALUES ('38', '16', '75');
INSERT INTO `sys_role_auth` VALUES ('39', '16', '76');
INSERT INTO `sys_role_auth` VALUES ('40', '16', '78');
INSERT INTO `sys_role_auth` VALUES ('41', '16', '1');
INSERT INTO `sys_role_auth` VALUES ('42', '16', '3');
INSERT INTO `sys_role_auth` VALUES ('43', '16', '4');
INSERT INTO `sys_role_auth` VALUES ('44', '16', '5');
INSERT INTO `sys_role_auth` VALUES ('45', '16', '7');
INSERT INTO `sys_role_auth` VALUES ('46', '16', '11');
INSERT INTO `sys_role_auth` VALUES ('47', '16', '12');
INSERT INTO `sys_role_auth` VALUES ('48', '16', '75');
INSERT INTO `sys_role_auth` VALUES ('49', '16', '76');
INSERT INTO `sys_role_auth` VALUES ('50', '16', '78');
INSERT INTO `sys_role_auth` VALUES ('51', '16', '1');
INSERT INTO `sys_role_auth` VALUES ('52', '16', '2');
INSERT INTO `sys_role_auth` VALUES ('53', '16', '8');
INSERT INTO `sys_role_auth` VALUES ('54', '16', '9');
INSERT INTO `sys_role_auth` VALUES ('55', '16', '10');
INSERT INTO `sys_role_auth` VALUES ('56', '16', '75');
INSERT INTO `sys_role_auth` VALUES ('57', '16', '76');
INSERT INTO `sys_role_auth` VALUES ('58', '16', '78');
INSERT INTO `sys_role_auth` VALUES ('62', '26', '78');
INSERT INTO `sys_role_auth` VALUES ('63', '26', '83');
INSERT INTO `sys_role_auth` VALUES ('64', '26', '88');
INSERT INTO `sys_role_auth` VALUES ('65', '26', '89');
INSERT INTO `sys_role_auth` VALUES ('66', '26', '90');
INSERT INTO `sys_role_auth` VALUES ('141', '6', '1');
INSERT INTO `sys_role_auth` VALUES ('142', '6', '5');
INSERT INTO `sys_role_auth` VALUES ('143', '15', '2');
INSERT INTO `sys_role_auth` VALUES ('144', '15', '8');
INSERT INTO `sys_role_auth` VALUES ('145', '15', '9');
INSERT INTO `sys_role_auth` VALUES ('146', '15', '10');
INSERT INTO `sys_role_auth` VALUES ('147', '15', '3');
INSERT INTO `sys_role_auth` VALUES ('148', '15', '7');
INSERT INTO `sys_role_auth` VALUES ('149', '15', '11');
INSERT INTO `sys_role_auth` VALUES ('150', '15', '12');
INSERT INTO `sys_role_auth` VALUES ('151', '15', '91');
INSERT INTO `sys_role_auth` VALUES ('152', '5', '2');
INSERT INTO `sys_role_auth` VALUES ('153', '5', '8');
INSERT INTO `sys_role_auth` VALUES ('154', '5', '9');
INSERT INTO `sys_role_auth` VALUES ('155', '5', '10');
INSERT INTO `sys_role_auth` VALUES ('156', '5', '3');
INSERT INTO `sys_role_auth` VALUES ('157', '5', '7');
INSERT INTO `sys_role_auth` VALUES ('158', '5', '11');
INSERT INTO `sys_role_auth` VALUES ('159', '5', '12');
INSERT INTO `sys_role_auth` VALUES ('160', '5', '91');
INSERT INTO `sys_role_auth` VALUES ('161', '1', '1');
INSERT INTO `sys_role_auth` VALUES ('162', '1', '2');
INSERT INTO `sys_role_auth` VALUES ('163', '1', '3');
INSERT INTO `sys_role_auth` VALUES ('164', '1', '4');
INSERT INTO `sys_role_auth` VALUES ('165', '1', '5');
INSERT INTO `sys_role_auth` VALUES ('166', '1', '7');
INSERT INTO `sys_role_auth` VALUES ('167', '1', '8');
INSERT INTO `sys_role_auth` VALUES ('168', '1', '9');
INSERT INTO `sys_role_auth` VALUES ('169', '1', '10');
INSERT INTO `sys_role_auth` VALUES ('170', '1', '11');
INSERT INTO `sys_role_auth` VALUES ('171', '1', '12');
INSERT INTO `sys_role_auth` VALUES ('172', '1', '91');
INSERT INTO `sys_role_auth` VALUES ('173', '1', '92');
INSERT INTO `sys_role_auth` VALUES ('174', '1', '93');
INSERT INTO `sys_role_auth` VALUES ('175', '1', '94');
INSERT INTO `sys_role_auth` VALUES ('176', '1', '95');

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
  `status` int(10) DEFAULT NULL COMMENT '状态',
  `is_del` tinyint(2) DEFAULT NULL COMMENT '删除标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `last_login_ip` varchar(200) DEFAULT NULL COMMENT '上次登陆ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_user` VALUES ('38', 'test222', '123', null, 'EVEN', 'test222@qq.com', null, null, null, null, '1', '1', '2017-12-22 17:28:34', '2017-12-22 17:28:34', null, null);
INSERT INTO `sys_user` VALUES ('39', '111', null, null, '111', '111@qq.com', null, null, null, '1', '1', '1', '2018-01-15 15:03:54', '2018-01-15 15:03:54', null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '38', '5');
