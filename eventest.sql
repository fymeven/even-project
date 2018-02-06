/*
Navicat MySQL Data Transfer

Source Server         : 47.100.0.82
Source Server Version : 50633
Source Host           : 47.100.0.82:3306
Source Database       : eventest

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2018-02-06 18:17:34
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
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_auth
-- ----------------------------
INSERT INTO `sys_auth` VALUES ('1', '系统管理', '系统管理设置2', 'system:manage', 'fa fa-desktop', '', '1', '1', '0', '1', '1', '2017-12-11 17:41:00', '2018-02-02 16:32:59');
INSERT INTO `sys_auth` VALUES ('2', '权限管理', '管理系统菜单', 'system:menu:manage', 'fa fa-user-secret', '/sysAuth/page', '2', '1', '1', '1', '2', '2017-12-11 17:41:00', '2018-01-31 10:45:18');
INSERT INTO `sys_auth` VALUES ('3', '角色管理', '管理系统角色', 'system:role:manage', 'fa fa-street-view', '/sysRole/page', '2', '1', '1', '1', '2', '2017-12-11 17:41:00', '2018-01-31 10:45:53');
INSERT INTO `sys_auth` VALUES ('4', '用户管理', '管理系统用户', 'system:user:manage', 'fa fa-user', '/sysUser/page', '2', '1', '1', '1', '2', '2017-12-11 17:41:00', '2018-01-31 10:46:11');
INSERT INTO `sys_auth` VALUES ('5', 'SQL监控', '实时监控sql情况', 'system:sql:view', 'fa fa-database', '/druid/sql', '2', '1', '1', '1', '2', '2017-12-11 17:41:00', '2018-01-31 10:58:34');
INSERT INTO `sys_auth` VALUES ('6', '一级测试菜单2', '一级测试菜单2', 'test:menu', '', '/test/menu1', '2', '1', '0', '1', '1', '2017-12-11 17:41:00', '2018-01-11 16:29:36');
INSERT INTO `sys_auth` VALUES ('7', '添加角色', '添加角色按钮', 'role:add', null, '', '3', '1', '3', '1', '3', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('8', '添加权限', '添加权限按钮', 'auth:add', null, '', '3', '1', '2', '1', '3', '2018-01-03 16:27:45', '2018-01-03 16:27:47');
INSERT INTO `sys_auth` VALUES ('9', '编辑权限', '编辑权限按钮', 'auth:edit', '', '', '3', '1', '2', '1', '3', '2018-01-03 16:27:45', '2018-01-03 16:27:47');
INSERT INTO `sys_auth` VALUES ('10', '删除权限', '删除权限按钮', 'auth:delete', '', '', '3', '1', '2', '1', '3', '2018-01-03 16:27:45', '2018-01-03 16:27:47');
INSERT INTO `sys_auth` VALUES ('11', '编辑角色', '编辑角色按钮', 'role:edit', null, null, '3', '1', '3', '1', '3', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('12', '删除角色', '删除角色按钮', 'role:delete', null, null, '3', '1', '3', '1', '2', '2017-12-11 17:41:00', '2017-12-11 17:41:00');
INSERT INTO `sys_auth` VALUES ('91', '菜单授权', null, 'role:auth', null, null, '3', '1', '3', '1', null, '2018-01-15 16:28:16', '2018-01-15 16:28:16');
INSERT INTO `sys_auth` VALUES ('92', '添加用户', null, 'user:add', null, null, '3', '1', '4', '1', null, '2018-01-15 16:30:54', '2018-01-15 16:30:54');
INSERT INTO `sys_auth` VALUES ('93', '编辑用户', null, 'user:edit', null, null, '3', '1', '4', '1', null, '2018-01-15 16:31:14', '2018-01-15 16:31:14');
INSERT INTO `sys_auth` VALUES ('94', '删除用户', null, 'user:delete', null, null, '3', '1', '4', '1', null, '2018-01-15 16:31:42', '2018-01-15 16:31:42');
INSERT INTO `sys_auth` VALUES ('95', '设置角色', null, 'user:role', null, null, '3', '1', '4', '1', null, '2018-01-15 16:32:23', '2018-01-15 16:32:23');
INSERT INTO `sys_auth` VALUES ('97', '组织架构', '组织架构目录', 'organization:manage', 'fa fa-sitemap', null, '1', '1', '0', '1', null, '2018-01-31 10:33:53', '2018-01-31 10:46:31');
INSERT INTO `sys_auth` VALUES ('98', '部门管理', '部门管理菜单', 'department:page', 'fa fa-anchor', '/department/page', '2', '1', '97', '1', null, '2018-01-31 10:36:18', '2018-01-31 10:55:54');
INSERT INTO `sys_auth` VALUES ('99', '组织架构图', '组织架构图展示页面', 'department:chart', 'fa fa-area-chart', '/department/chart', '2', '1', '97', '1', null, '2018-01-31 10:39:43', '2018-02-06 10:06:04');
INSERT INTO `sys_auth` VALUES ('100', '添加部门', null, 'department:add', null, null, '3', '1', '98', '1', null, '2018-01-31 18:05:10', '2018-01-31 18:05:10');
INSERT INTO `sys_auth` VALUES ('101', '编辑部门', null, 'department:edit', null, null, '3', '1', '98', '1', null, '2018-01-31 18:05:45', '2018-01-31 18:05:45');
INSERT INTO `sys_auth` VALUES ('102', '删除部门', null, 'department:delete', null, null, '3', '1', '98', '1', null, '2018-01-31 18:06:13', '2018-02-01 10:01:30');
INSERT INTO `sys_auth` VALUES ('103', '通信管理', null, 'message:manage', 'fa fa-commenting', null, '1', '1', '0', '1', null, '2018-02-05 18:24:54', '2018-02-06 14:07:49');
INSERT INTO `sys_auth` VALUES ('104', '即时聊天', null, 'message:privateChat', 'fa fa-qq', '/message/privateChat', '2', '1', '103', '1', null, '2018-02-05 18:27:30', '2018-02-06 14:08:18');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(200) DEFAULT NULL COMMENT '部门名称',
  `dept_manager_id` bigint(20) DEFAULT NULL COMMENT '部门负责人id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '股东大会', '2', '0');
INSERT INTO `sys_dept` VALUES ('2', '董事会', '2', '1');
INSERT INTO `sys_dept` VALUES ('3', '总经理', '3', '2');
INSERT INTO `sys_dept` VALUES ('4', '业务部', '4', '3');
INSERT INTO `sys_dept` VALUES ('5', '生产部', '5', '3');
INSERT INTO `sys_dept` VALUES ('6', '技术部', null, '3');
INSERT INTO `sys_dept` VALUES ('7', '财务部', '20', '3');
INSERT INTO `sys_dept` VALUES ('11', '销售部', '2', '3');

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
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容',
  `from_id` bigint(20) DEFAULT NULL COMMENT '发送人id',
  `from_name` varchar(255) DEFAULT NULL COMMENT '发送人名称',
  `type` int(4) DEFAULT NULL COMMENT '消息类型',
  `to_id` bigint(20) DEFAULT NULL COMMENT '接收人id',
  `to_name` varchar(255) DEFAULT NULL COMMENT '接收人名称',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `source` varchar(255) DEFAULT NULL COMMENT '来源',
  `is_read` tinyint(2) DEFAULT NULL COMMENT '是否已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_message
-- ----------------------------
INSERT INTO `sys_message` VALUES ('1', null, '3232', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:25:32', null, '1');
INSERT INTO `sys_message` VALUES ('2', null, '23', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:31:48', null, '1');
INSERT INTO `sys_message` VALUES ('3', null, '2323', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:34:43', null, '1');
INSERT INTO `sys_message` VALUES ('4', null, '2323\n423423', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:34:46', null, '1');
INSERT INTO `sys_message` VALUES ('5', null, '2323\n423423\n2323', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:34:51', null, '1');
INSERT INTO `sys_message` VALUES ('6', null, '32', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:49:02', null, '1');
INSERT INTO `sys_message` VALUES ('7', null, '332', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:51:45', null, '1');
INSERT INTO `sys_message` VALUES ('8', null, '332\n24332', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:51:49', null, '1');
INSERT INTO `sys_message` VALUES ('9', null, '111', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:54:46', null, '1');
INSERT INTO `sys_message` VALUES ('10', null, '111\n3223', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:54:47', null, '1');
INSERT INTO `sys_message` VALUES ('11', null, '111', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:57:09', null, '1');
INSERT INTO `sys_message` VALUES ('12', null, '222', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 16:57:12', null, '1');
INSERT INTO `sys_message` VALUES ('13', null, '111', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:09:00', null, '1');
INSERT INTO `sys_message` VALUES ('14', null, '222', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:09:04', null, '1');
INSERT INTO `sys_message` VALUES ('15', null, '111', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:10:52', null, '1');
INSERT INTO `sys_message` VALUES ('16', null, '111\n222', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:10:53', null, '1');
INSERT INTO `sys_message` VALUES ('17', null, '111\n222\n323', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:10:54', null, '1');
INSERT INTO `sys_message` VALUES ('18', null, '111', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:18:26', null, '1');
INSERT INTO `sys_message` VALUES ('19', null, '111', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:23:46', null, '1');
INSERT INTO `sys_message` VALUES ('20', null, '111', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:27:07', null, '1');
INSERT INTO `sys_message` VALUES ('21', null, '111\n222', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:27:10', null, '1');
INSERT INTO `sys_message` VALUES ('22', null, '2121', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:32:04', null, '1');
INSERT INTO `sys_message` VALUES ('23', null, '222', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:35:26', null, '1');
INSERT INTO `sys_message` VALUES ('24', null, '222', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:38:27', null, '1');
INSERT INTO `sys_message` VALUES ('25', null, '121', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:39:26', null, '1');
INSERT INTO `sys_message` VALUES ('26', null, '111', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:42:00', null, '1');
INSERT INTO `sys_message` VALUES ('27', null, '222', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:43:58', null, '1');
INSERT INTO `sys_message` VALUES ('28', null, '222\n111', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:44:14', null, '1');
INSERT INTO `sys_message` VALUES ('29', null, '233', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:45:00', null, '1');
INSERT INTO `sys_message` VALUES ('30', null, '23', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 17:45:44', null, '1');
INSERT INTO `sys_message` VALUES ('31', null, '12', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 18:01:54', null, '1');
INSERT INTO `sys_message` VALUES ('32', null, '12\n233333333333333333333333333333333333333333333333333333', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 18:02:22', null, '1');
INSERT INTO `sys_message` VALUES ('33', null, '2323', '1', 'ADMIN', null, '1', 'ADMIN', '2018-02-06 18:03:45', null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'isAdmin', null, null, '1', null, null);
INSERT INTO `sys_role` VALUES ('2', 'nomal', 'isNomal', null, null, '2', null, null);
INSERT INTO `sys_role` VALUES ('3', 'role3', 'isRole3', null, null, '2', '2017-12-14 18:08:47', '2017-12-14 18:08:50');
INSERT INTO `sys_role` VALUES ('4', 'role4', 'isRole4', null, null, '2', '2017-12-14 18:08:47', '2017-12-14 18:08:50');
INSERT INTO `sys_role` VALUES ('5', '测试', '测试角色', null, null, '1', '2017-12-20 10:33:45', '2017-12-20 10:33:45');
INSERT INTO `sys_role` VALUES ('6', '运维', '运维角色', null, null, '1', '2017-12-20 10:35:01', '2017-12-20 10:35:01');
INSERT INTO `sys_role` VALUES ('7', 'aaa', 'aaadesc', null, null, '2', '2017-12-20 10:35:52', '2017-12-20 10:35:52');
INSERT INTO `sys_role` VALUES ('8', '运营', '运营角色', null, null, '1', '2017-12-20 10:39:13', '2017-12-20 10:39:13');
INSERT INTO `sys_role` VALUES ('9', '搬砖工', '搬砖工角色', null, null, '1', '2017-12-20 10:42:06', '2017-12-20 10:42:06');
INSERT INTO `sys_role` VALUES ('10', '策划1', '策划角色1', null, null, '2', '2017-12-20 10:42:06', '2017-12-22 16:20:10');
INSERT INTO `sys_role` VALUES ('11', 'sss', 'sssdesc', null, null, '2', '2017-12-20 13:57:01', '2017-12-20 13:57:01');
INSERT INTO `sys_role` VALUES ('12', '111', '111', null, null, '2', '2017-12-20 14:30:31', '2017-12-20 14:30:31');
INSERT INTO `sys_role` VALUES ('13', '2332', '3223', null, null, '1', '2018-01-11 18:39:40', '2018-01-11 18:39:40');
INSERT INTO `sys_role` VALUES ('14', '2323', '2323', null, null, '1', '2018-01-11 18:45:10', '2018-01-11 18:45:10');
INSERT INTO `sys_role` VALUES ('15', '111', '1212', null, null, '1', '2018-01-11 18:45:19', '2018-01-11 18:45:19');
INSERT INTO `sys_role` VALUES ('16', '555', '555', null, null, '1', '2018-01-12 09:29:06', '2018-01-12 09:29:06');
INSERT INTO `sys_role` VALUES ('17', '6661', '666', null, null, '2', '2018-01-12 09:29:21', '2018-01-12 10:14:45');
INSERT INTO `sys_role` VALUES ('18', '2332', '2332', null, null, '2', '2018-01-12 10:00:28', '2018-01-12 10:00:28');
INSERT INTO `sys_role` VALUES ('19', 'fefw', '23', null, null, '2', '2018-01-12 11:23:15', '2018-01-12 11:23:15');
INSERT INTO `sys_role` VALUES ('20', 'fewqqqqqqqqqqqqqqqqq', 'eqf', null, null, '2', '2018-01-12 11:23:41', '2018-01-12 11:23:47');
INSERT INTO `sys_role` VALUES ('21', '2323', '2323', null, null, '2', '2018-01-12 15:02:55', '2018-01-12 15:02:55');
INSERT INTO `sys_role` VALUES ('22', '2323', '2323', null, null, '2', '2018-01-12 15:03:05', '2018-01-12 15:03:05');
INSERT INTO `sys_role` VALUES ('23', '232', '323', null, null, '2', '2018-01-12 15:18:16', '2018-01-12 15:18:16');
INSERT INTO `sys_role` VALUES ('24', '2323', '2332', null, null, '2', '2018-01-12 15:50:39', '2018-01-12 15:50:39');
INSERT INTO `sys_role` VALUES ('25', '2323', '2323', null, null, '2', '2018-01-12 15:50:44', '2018-01-12 15:50:44');
INSERT INTO `sys_role` VALUES ('26', '231112', '2323', null, null, '2', '2018-01-12 15:51:53', '2018-01-15 11:05:42');
INSERT INTO `sys_role` VALUES ('27', 'huh', '23r', null, null, '2', '2018-01-15 14:56:59', '2018-01-15 14:56:59');
INSERT INTO `sys_role` VALUES ('28', '23', '3223', null, null, '1', '2018-01-30 18:31:50', '2018-01-30 18:31:50');
INSERT INTO `sys_role` VALUES ('29', '23', '232', null, null, '1', '2018-01-30 18:31:53', '2018-01-30 18:31:53');
INSERT INTO `sys_role` VALUES ('30', '231', '23232', null, null, '1', '2018-02-02 16:30:26', '2018-02-02 16:43:18');

-- ----------------------------
-- Table structure for sys_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_auth`;
CREATE TABLE `sys_role_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  `auth_id` bigint(20) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=442 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_auth
-- ----------------------------
INSERT INTO `sys_role_auth` VALUES ('22', '9', '75');
INSERT INTO `sys_role_auth` VALUES ('23', '9', '76');
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
INSERT INTO `sys_role_auth` VALUES ('177', '8', '78');
INSERT INTO `sys_role_auth` VALUES ('344', '15', '1');
INSERT INTO `sys_role_auth` VALUES ('345', '15', '2');
INSERT INTO `sys_role_auth` VALUES ('346', '15', '3');
INSERT INTO `sys_role_auth` VALUES ('347', '15', '4');
INSERT INTO `sys_role_auth` VALUES ('348', '15', '5');
INSERT INTO `sys_role_auth` VALUES ('349', '15', '7');
INSERT INTO `sys_role_auth` VALUES ('350', '15', '8');
INSERT INTO `sys_role_auth` VALUES ('351', '15', '9');
INSERT INTO `sys_role_auth` VALUES ('352', '15', '10');
INSERT INTO `sys_role_auth` VALUES ('353', '15', '11');
INSERT INTO `sys_role_auth` VALUES ('354', '15', '12');
INSERT INTO `sys_role_auth` VALUES ('355', '15', '91');
INSERT INTO `sys_role_auth` VALUES ('356', '15', '92');
INSERT INTO `sys_role_auth` VALUES ('357', '15', '93');
INSERT INTO `sys_role_auth` VALUES ('358', '15', '94');
INSERT INTO `sys_role_auth` VALUES ('359', '15', '95');
INSERT INTO `sys_role_auth` VALUES ('360', '5', '1');
INSERT INTO `sys_role_auth` VALUES ('361', '5', '2');
INSERT INTO `sys_role_auth` VALUES ('362', '5', '3');
INSERT INTO `sys_role_auth` VALUES ('363', '5', '7');
INSERT INTO `sys_role_auth` VALUES ('364', '5', '8');
INSERT INTO `sys_role_auth` VALUES ('365', '5', '9');
INSERT INTO `sys_role_auth` VALUES ('366', '5', '10');
INSERT INTO `sys_role_auth` VALUES ('367', '5', '11');
INSERT INTO `sys_role_auth` VALUES ('368', '5', '12');
INSERT INTO `sys_role_auth` VALUES ('410', '13', '78');
INSERT INTO `sys_role_auth` VALUES ('411', '13', '79');
INSERT INTO `sys_role_auth` VALUES ('412', '30', '78');
INSERT INTO `sys_role_auth` VALUES ('413', '30', '79');
INSERT INTO `sys_role_auth` VALUES ('414', '28', '97');
INSERT INTO `sys_role_auth` VALUES ('415', '28', '98');
INSERT INTO `sys_role_auth` VALUES ('416', '28', '100');
INSERT INTO `sys_role_auth` VALUES ('417', '28', '101');
INSERT INTO `sys_role_auth` VALUES ('418', '1', '1');
INSERT INTO `sys_role_auth` VALUES ('419', '1', '2');
INSERT INTO `sys_role_auth` VALUES ('420', '1', '3');
INSERT INTO `sys_role_auth` VALUES ('421', '1', '4');
INSERT INTO `sys_role_auth` VALUES ('422', '1', '5');
INSERT INTO `sys_role_auth` VALUES ('423', '1', '7');
INSERT INTO `sys_role_auth` VALUES ('424', '1', '8');
INSERT INTO `sys_role_auth` VALUES ('425', '1', '9');
INSERT INTO `sys_role_auth` VALUES ('426', '1', '10');
INSERT INTO `sys_role_auth` VALUES ('427', '1', '11');
INSERT INTO `sys_role_auth` VALUES ('428', '1', '12');
INSERT INTO `sys_role_auth` VALUES ('429', '1', '91');
INSERT INTO `sys_role_auth` VALUES ('430', '1', '92');
INSERT INTO `sys_role_auth` VALUES ('431', '1', '93');
INSERT INTO `sys_role_auth` VALUES ('432', '1', '94');
INSERT INTO `sys_role_auth` VALUES ('433', '1', '95');
INSERT INTO `sys_role_auth` VALUES ('434', '1', '97');
INSERT INTO `sys_role_auth` VALUES ('435', '1', '98');
INSERT INTO `sys_role_auth` VALUES ('436', '1', '99');
INSERT INTO `sys_role_auth` VALUES ('437', '1', '100');
INSERT INTO `sys_role_auth` VALUES ('438', '1', '101');
INSERT INTO `sys_role_auth` VALUES ('439', '1', '102');
INSERT INTO `sys_role_auth` VALUES ('440', '1', '103');
INSERT INTO `sys_role_auth` VALUES ('441', '1', '104');

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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123', null, 'ADMIN', 'admin@qq.com', 'http://ozwpnu2pa.bkt.clouddn.com/profile.jpg', '1', '15112341234', '2', '1', '1', null, null, '2017-11-08 21:17:26', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('2', 'even', '123', null, 'EVEN', 'even@qq.com', 'http://ozwpnu2pa.bkt.clouddn.com/profile.jpg', '2', '15212345678', '1', '1', '1', null, null, '2017-11-08 21:17:26', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '38', '5');
INSERT INTO `sys_user_role` VALUES ('4', '30', '1');
INSERT INTO `sys_user_role` VALUES ('5', '30', '5');
INSERT INTO `sys_user_role` VALUES ('6', '20', '6');
INSERT INTO `sys_user_role` VALUES ('7', '20', '8');
INSERT INTO `sys_user_role` VALUES ('8', '20', '9');
INSERT INTO `sys_user_role` VALUES ('9', '16', '6');
INSERT INTO `sys_user_role` VALUES ('44', '48', '5');
INSERT INTO `sys_user_role` VALUES ('45', '48', '6');
