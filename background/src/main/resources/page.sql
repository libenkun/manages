/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : page

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-08-12 18:04:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('1292748966458884097', '酒类', '2020-08-10 17:05:46', '2020-08-10 17:05:46');

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` bigint(20) NOT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL COMMENT '图片',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `states` tinyint(2) DEFAULT NULL,
  `pid` bigint(20) DEFAULT '0' COMMENT '父id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1290188164052922369', '用户管理', 'path,', null, 'ss', '2020-08-03 15:30:04', '2020-08-03 15:30:04', '1', '0');
INSERT INTO `tb_menu` VALUES ('1291303975261945858', '用户列表', 'user', null, 'eee', '2020-08-06 17:23:54', '2020-08-06 17:23:54', '1', '1290188164052922369');
INSERT INTO `tb_menu` VALUES ('1292725922017406978', '权限管理', 'www.baidu.com', null, null, '2020-08-10 15:34:12', '2020-08-10 15:34:12', '1', '0');
INSERT INTO `tb_menu` VALUES ('1292726014279512066', '角色列表', 'roles', null, null, '2020-08-10 15:34:34', '2020-08-10 15:34:34', '1', '1292725922017406978');
INSERT INTO `tb_menu` VALUES ('1292726137977925633', '商品管理', 'commodity', null, null, '2020-08-10 15:35:04', '2020-08-10 15:35:04', '1', '0');
INSERT INTO `tb_menu` VALUES ('1292726192201887746', '商品列表', 'commodityList', null, null, '2020-08-10 15:35:17', '2020-08-10 15:35:17', '1', '1292726137977925633');
INSERT INTO `tb_menu` VALUES ('1292726267183460353', '订单管理', 'www.baidu.com', null, null, '2020-08-10 15:35:34', '2020-08-10 15:35:34', '1', '0');
INSERT INTO `tb_menu` VALUES ('1292726307331338241', '添加', 'www.baidu.com', null, null, '2020-08-10 15:35:44', '2020-08-10 15:35:44', '1', '1292726267183460353');
INSERT INTO `tb_menu` VALUES ('1292726380085735426', '数据统计', 'www.baidu.com', null, null, '2020-08-10 15:36:01', '2020-08-10 15:36:01', '1', '0');
INSERT INTO `tb_menu` VALUES ('1292731715781488641', '权限列表', 'www.baidu.com', null, null, '2020-08-10 15:57:13', '2020-08-10 15:57:13', '1', '1292725922017406978');
INSERT INTO `tb_menu` VALUES ('1292733113608794113', '分类参数', 'www.baidu.com', null, null, '2020-08-10 16:02:47', '2020-08-10 16:02:47', '1', '1292726137977925633');
INSERT INTO `tb_menu` VALUES ('1292733174052909058', '商品分类', 'www.baidu.com', null, null, '2020-08-10 16:03:01', '2020-08-10 16:03:01', '1', '1292726137977925633');

-- ----------------------------
-- Table structure for tb_menu_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu_permission`;
CREATE TABLE `tb_menu_permission` (
  `id` bigint(20) NOT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu_permission
-- ----------------------------
INSERT INTO `tb_menu_permission` VALUES ('1290213373900308482', '1290212034193473537', '1290188164052922369', '2020-08-03 17:10:14', '2020-08-03 17:10:14');
INSERT INTO `tb_menu_permission` VALUES ('1292727300370558977', '1290212034193473537', '1292725922017406978', '2020-08-10 15:39:41', '2020-08-10 15:39:41');
INSERT INTO `tb_menu_permission` VALUES ('1292727431308341249', '1290212034193473537', '1292726137977925633', '2020-08-10 15:40:12', '2020-08-10 15:40:12');
INSERT INTO `tb_menu_permission` VALUES ('1292727476749430785', '1290212034193473537', '1292726267183460353', '2020-08-10 15:40:23', '2020-08-10 15:40:23');
INSERT INTO `tb_menu_permission` VALUES ('1292727510316445697', '1290212034193473537', '1292726380085735426', '2020-08-10 15:40:31', '2020-08-10 15:40:31');

-- ----------------------------
-- Table structure for tb_psermission
-- ----------------------------
DROP TABLE IF EXISTS `tb_psermission`;
CREATE TABLE `tb_psermission` (
  `id` bigint(20) NOT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` tinyint(2) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_psermission
-- ----------------------------
INSERT INTO `tb_psermission` VALUES ('1290212034193473537', '0', '管理员权限', '1', '2020-08-03 17:04:55', '2020-08-03 17:04:55');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL COMMENT '图片',
  `path` varchar(255) DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `states` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1290198153911971842', '管理员', 'www.abc.com', 'www.abc.com', '2020-08-03 16:09:45', '2020-08-03 16:09:45', '1');

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------
INSERT INTO `tb_role_permission` VALUES ('1290213894077890561', '1290198153911971842', '1290212034193473537', '2020-08-03 17:12:18', '2020-08-03 17:12:18');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `states` tinyint(2) DEFAULT '0',
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'sss', 'fdfs', '1', '1457722982@qq.com', '13529071895', '2020-08-10 15:22:10', null);
INSERT INTO `tb_user` VALUES ('1289102228988719105', 'lbk', '123456', '1', '1457722982@qq.com', '19987831285', '2020-08-07 15:22:17', null);
INSERT INTO `tb_user` VALUES ('1293455952955650050', 'admin', 'admin01', '0', '1457722982@qq.com', '13529071895', '2020-08-12 15:55:05', '2020-08-12 15:55:05');
INSERT INTO `tb_user` VALUES ('1293457070825746433', 'admin02', 'admin02', '0', '1457722982@qq.com', '13529071895', '2020-08-12 15:59:32', '2020-08-12 15:59:32');
INSERT INTO `tb_user` VALUES ('1293457374497550337', 'admin03', 'admin03', '0', '1457722982@qq.com', '13888888888', '2020-08-12 16:00:44', '2020-08-12 16:00:44');
INSERT INTO `tb_user` VALUES ('1293458039810633729', 'add', 'add0123456', '0', '14502425669@qq.com', '13899999999', '2020-08-12 16:03:23', '2020-08-12 16:03:23');
INSERT INTO `tb_user` VALUES ('1293458866088521729', 'lbk00', 'lbk123456', '0', '1457722982@qq.com', '13101234567', '2020-08-12 16:06:40', '2020-08-12 16:06:40');
INSERT INTO `tb_user` VALUES ('1293459200525545473', 'lbk123', 'lbk123456', '0', '1457722982@qq.com', '13101234567', '2020-08-12 16:07:59', '2020-08-12 16:07:59');
INSERT INTO `tb_user` VALUES ('1293459554017292290', 'admin12345', 'admin123456', '0', '1457722982@qq.com', '13529071895', '2020-08-12 16:09:24', '2020-08-12 16:09:24');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1290544423876747265', '1289102228988719105', '1290198153911971842', '2020-08-04 15:05:43', '2020-08-04 15:05:43');
