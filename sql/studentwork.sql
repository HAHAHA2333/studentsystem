/*
Navicat MySQL Data Transfer

Source Server         : tt
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : studentwork

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-03-20 22:39:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admissionlist
-- ----------------------------
DROP TABLE IF EXISTS `admissionlist`;
CREATE TABLE `admissionlist` (
  `id` int(11) NOT NULL,
  `studentNo` varchar(255) DEFAULT NULL,
  `used` varchar(2) DEFAULT NULL,
  `deptNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admissionlist
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deptNo` int(11) NOT NULL,
  `deptName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '1', '地理科学学院');
INSERT INTO `dept` VALUES ('2', '2', '文学院');
INSERT INTO `dept` VALUES ('3', '3', '历史系');
INSERT INTO `dept` VALUES ('4', '4', '经济系');
INSERT INTO `dept` VALUES ('5', '5', '数学系');
INSERT INTO `dept` VALUES ('6', '6', '化学系');
INSERT INTO `dept` VALUES ('7', '7', '计算机系');
INSERT INTO `dept` VALUES ('8', '8', '美术系');
INSERT INTO `dept` VALUES ('9', '9', '体育系');
INSERT INTO `dept` VALUES ('10', '10', '设计系');
INSERT INTO `dept` VALUES ('11', '11', '书法系');
INSERT INTO `dept` VALUES ('12', '12', '法律\r\n系');
INSERT INTO `dept` VALUES ('13', '13', '马克思主义学院');
INSERT INTO `dept` VALUES ('14', '14', '教育学院');
INSERT INTO `dept` VALUES ('15', '15', '外语系');
INSERT INTO `dept` VALUES ('16', '16', '物理\r\n系');
INSERT INTO `dept` VALUES ('17', '17', '生物系');
INSERT INTO `dept` VALUES ('18', '18', '音乐\r\n\r\n系');
INSERT INTO `dept` VALUES ('19', '19', '舞蹈\r\n系');
INSERT INTO `dept` VALUES ('20', '20', '管理系');
INSERT INTO `dept` VALUES ('21', '21', '影视艺术\r\n系');
INSERT INTO `dept` VALUES ('22', '22', '继续教育学院');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL,
  `studentName` varchar(5) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `origin` varchar(25) DEFAULT NULL,
  `admissionSchool` varchar(20) DEFAULT NULL,
  `subjectCategory` varchar(10) DEFAULT NULL,
  `achievement` int(3) DEFAULT NULL,
  `chinese` int(3) DEFAULT NULL,
  `maths` int(3) DEFAULT NULL,
  `engllish` int(3) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherNo` varchar(10) NOT NULL,
  `teacherName` varchar(5) NOT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `used` int(2) DEFAULT NULL COMMENT '是否有效识别',
  PRIMARY KEY (`teacherNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
