/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : crms

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-04-11 17:44:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_name` varchar(50) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  `lesson_time` double DEFAULT NULL,
  `lesson_score` double DEFAULT NULL,
  `lesson_remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES ('1', 'c语言程序设计', '2018-08-11 00:00:00', '4', '3.5', '自带U盘');
INSERT INTO `lesson` VALUES ('2', '网络工程', '2019-03-21 02:03:00', '3.5', '2.5', '记得带好笔记');
INSERT INTO `lesson` VALUES ('3', 'java程序设计', '2019-03-21 02:03:00', '4', '2.5', '自带U盘，进行GUI教学');
INSERT INTO `lesson` VALUES ('4', '数据结构', '2019-03-21 02:03:00', '6', '6', '带笔记，记得写好笔记');
INSERT INTO `lesson` VALUES ('5', 'mySql数据库', '2019-03-21 02:03:00', '4', '6', '= =、、没啥好说的了');
INSERT INTO `lesson` VALUES ('6', '软件工程导论', '2019-03-22 02:03:00', '4', '2.5', '带笔记');
INSERT INTO `lesson` VALUES ('8', '大学数学', '2019-03-29 19:51:00', '4', '2.5', '很重要，划重点，所有人必须来');
INSERT INTO `lesson` VALUES ('13', '马克思哲学', '2019-03-24 02:03:00', '4', '6', '软件工程专业，需要补习的学生来');

-- ----------------------------
-- Table structure for lessontable
-- ----------------------------
DROP TABLE IF EXISTS `lessontable`;
CREATE TABLE `lessontable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `season` varchar(10) DEFAULT NULL,
  `lessonIMagePath` varchar(52) DEFAULT NULL,
  `current` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lessontable
-- ----------------------------
INSERT INTO `lessontable` VALUES ('1', 'spring', 'images/spring.jpg', 'spring');
INSERT INTO `lessontable` VALUES ('2', 'summer', 'images/summer.jpg', 'spring');
INSERT INTO `lessontable` VALUES ('3', 'winter', 'images/winter.jpg', 'spring');
INSERT INTO `lessontable` VALUES ('4', 'autumn', 'images/autumn.jpg', 'spring');

-- ----------------------------
-- Table structure for mechine
-- ----------------------------
DROP TABLE IF EXISTS `mechine`;
CREATE TABLE `mechine` (
  `id` int(52) NOT NULL AUTO_INCREMENT,
  `equipment_name` varchar(52) DEFAULT NULL,
  `logdate` datetime DEFAULT NULL,
  `computer_room` varchar(52) DEFAULT NULL,
  `is_normal` tinyint(1) DEFAULT NULL,
  `repair_man` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mechine
-- ----------------------------
INSERT INTO `mechine` VALUES ('2', '显示器', '2019-03-23 18:20:50', '二教三楼六机房12号', '0', 'zhou', '17696542240', '显示器花屏，请速换', '0');
INSERT INTO `mechine` VALUES ('5', '键盘', '2019-03-24 13:46:28', '二教三楼六机房11号', '1', 'zhou', '17696542240', '123456', '0');
INSERT INTO `mechine` VALUES ('7', '机箱', '2019-03-25 10:37:33', '二教三楼六机房11号', '0', 'zhou', '17696542240', '报修，机箱盖开了', '0');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(20) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `filename` varchar(200) DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统设置', '0', null, '2');
INSERT INTO `menu` VALUES ('2', '课表管理', '0', null, '2');
INSERT INTO `menu` VALUES ('3', '角色管理', '1', 'sys/role', '1');
INSERT INTO `menu` VALUES ('4', '权限管理', '1', 'sys/privilege', '1');
INSERT INTO `menu` VALUES ('5', '修改课表', '2', 'class/timetable_choice', '1');
INSERT INTO `menu` VALUES ('6', '查询课表', '2', 'class/timetable_show', '2');
INSERT INTO `menu` VALUES ('7', '个人信息管理', '1', 'sys/self_message', '2');
INSERT INTO `menu` VALUES ('8', '设备管理', '0', null, '2');
INSERT INTO `menu` VALUES ('9', '设备查询', '8', 'equipment/equipment_sel', '2');
INSERT INTO `menu` VALUES ('10', '提交损坏设备', '8', 'equipment/equipment_add', '2');
INSERT INTO `menu` VALUES ('11', '请求发布', '0', null, '2');
INSERT INTO `menu` VALUES ('12', '增加请求', '11', 'orders/orders_add', '2');
INSERT INTO `menu` VALUES ('13', '查询请求', '11', 'orders/orders_sel', '1');
INSERT INTO `menu` VALUES ('14', '串课加课', '0', null, '2');
INSERT INTO `menu` VALUES ('15', '增加串课', '14', 'class/lesson_add', '1');
INSERT INTO `menu` VALUES ('16', '查询串课', '14', 'class/lesson_sel', '2');
INSERT INTO `menu` VALUES ('17', '留言板', '0', null, '0');
INSERT INTO `menu` VALUES ('18', '写留言', '17', 'usr/writeMess', '2');
INSERT INTO `menu` VALUES ('19', '留言管理', '17', 'sys/contrMess', '1');
INSERT INTO `menu` VALUES ('21', '我发布的订单', '11', 'orders/orders_mine', '2');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单Id主键自动生成',
  `oid` varchar(40) DEFAULT NULL COMMENT '服务订单号UUID',
  `cid` varchar(50) DEFAULT NULL COMMENT '客户id',
  `cname` varchar(20) DEFAULT NULL COMMENT '客户名',
  `cphone` varchar(20) DEFAULT NULL COMMENT '客户电话',
  `start_time` datetime DEFAULT NULL COMMENT '服务时间',
  `service_type` varchar(20) DEFAULT NULL COMMENT '服务类型',
  `service_address` varchar(50) DEFAULT NULL COMMENT '服务地点',
  `payment` float DEFAULT NULL COMMENT '服务金额',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `status` tinyint(1) DEFAULT NULL COMMENT '订单状态',
  `pid` varchar(50) DEFAULT NULL COMMENT '揽单人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('11', 'b828ba4844ee4b3f8d0b5f2916791d0c', '1108563355335004160', 'zhou', '15811111111', '2010-03-04 02:03:00', 'computerMaintain', '13舍203', '15', '装系统', '1', '1108647251300978688');
INSERT INTO `orders` VALUES ('12', '051e9f47796d49e48e40aa261ec35a18', '1108563355335004160', 'zhou', '15811111111', '2019-03-25 02:03:00', 'softInstall', '13舍203', '10', '安装office', '1', '1108563355335004160');
INSERT INTO `orders` VALUES ('14', '098b3c2b441445a89948f6ad401f6805', '1108570335000793088', 'shuo', '15811111112', '2010-03-04 02:03:00', 'computerMaintain', '13舍204', '10', '笔记本换硅脂', '1', '1108563355335004160');
INSERT INTO `orders` VALUES ('16', 'c924e61fdc5f405ca9586117eebb129b', '1108570335000793088', '阿哲', '15844444444', '2019-03-30 02:03:00', 'softInstall', '13舍504', '5', '安装MySql', '0', '0');
INSERT INTO `orders` VALUES ('17', '8b18b04505b04621b4b7dda56416bfe7', '1108570335000793088', 'shuo', '15898989898', '2019-03-26 02:03:00', 'softInstall', '132603', '20', '修手机', '0', '0');

-- ----------------------------
-- Table structure for season
-- ----------------------------
DROP TABLE IF EXISTS `season`;
CREATE TABLE `season` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `options` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of season
-- ----------------------------
INSERT INTO `season` VALUES ('1', 'summer');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `uid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(40) DEFAULT NULL COMMENT '密码',
  `status` int(11) DEFAULT NULL COMMENT '用户权限',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('10', '1108562278418092032', 'daqiang', 'e4ff826d3d9f6446f21d2f085fc5f4bb', '2', '123', '1429526644@qq.com');
INSERT INTO `student` VALUES ('11', '1108563355335004160', 'zhou', 'f757e8937c9b7dafe91b466a9b308501', '1', '17696542240', '1429526644@qq.com');
INSERT INTO `student` VALUES ('13', '1108570335000793088', 'shuo', 'e4ff826d3d9f6446f21d2f085fc5f4bb', '2', '15895298585', '1429526644@qq.com');
INSERT INTO `student` VALUES ('14', '1108581034854846464', 'xiaozhiqiang', 'a93d97e3b67b69b39ec31071d3ecacdb', '1', '123456', '1429526644@qq.com');
INSERT INTO `student` VALUES ('15', '1108647251300978688', 'xia', 'e4ff826d3d9f6446f21d2f085fc5f4bb', '1', '17696542241', '1429526644@qq.com');
INSERT INTO `student` VALUES ('16', '1108990589304705024', 'mestest', 'e4ff826d3d9f6446f21d2f085fc5f4bb', '2', '123456', '1429526644@qq.com');
INSERT INTO `student` VALUES ('17', '1109047816254263296', 'shuoshuo', 'e4ff826d3d9f6446f21d2f085fc5f4bb', '1', '1074191791', '1074191791@163.com');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(22) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhou', 'tiger');
INSERT INTO `user` VALUES ('2', 'shuo', '123');
