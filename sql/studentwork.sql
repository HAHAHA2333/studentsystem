/*
Navicat MySQL Data Transfer

Source Server         : tt
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : studentwork

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-03-21 22:55:25
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
  `deptName` varchar(255) DEFAULT NULL,
  `subjectCategory` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '地理科学学院', '地质勘察');
INSERT INTO `dept` VALUES ('2', '文学院', '现代小说写作');
INSERT INTO `dept` VALUES ('3', '历史系', '文言文研究');
INSERT INTO `dept` VALUES ('4', '经济系', '金融学');
INSERT INTO `dept` VALUES ('5', '数学系', '高斯定理深造');
INSERT INTO `dept` VALUES ('6', '化学系', '有机物研究');
INSERT INTO `dept` VALUES ('7', '计算机系', '软件工程');
INSERT INTO `dept` VALUES ('8', '美术系', '素描');
INSERT INTO `dept` VALUES ('9', '体育系', '篮球艺术');
INSERT INTO `dept` VALUES ('10', '设计系', '室内设计');
INSERT INTO `dept` VALUES ('11', '书法系', '书法艺术');
INSERT INTO `dept` VALUES ('12', '法律\r\n系', '刑法学');
INSERT INTO `dept` VALUES ('13', '马克思主义学院', '马克思主义');
INSERT INTO `dept` VALUES ('14', '教育学院', '教育学院');
INSERT INTO `dept` VALUES ('15', '外语系', '英语');
INSERT INTO `dept` VALUES ('16', '物理\r\n系', '理论物理');
INSERT INTO `dept` VALUES ('17', '生物系', '生物技术与生活');
INSERT INTO `dept` VALUES ('18', '音乐\r\n\r\n系', '古典音乐');
INSERT INTO `dept` VALUES ('19', '舞蹈\r\n系', '芭蕾');
INSERT INTO `dept` VALUES ('20', '管理系', '工商管理');
INSERT INTO `dept` VALUES ('21', '影视艺术\r\n系', '影视视觉');
INSERT INTO `dept` VALUES ('22', '继续教育学院', '继续教育学院');
INSERT INTO `dept` VALUES ('23', '地理科学学院', '地质构造');
INSERT INTO `dept` VALUES ('24', '文学学院', '中华国学');
INSERT INTO `dept` VALUES ('25', '历史系', '考古学');
INSERT INTO `dept` VALUES ('26', '经济系', '投资学');
INSERT INTO `dept` VALUES ('27', '数学系', '古典数学');
INSERT INTO `dept` VALUES ('28', '化学系', '无机物化学');
INSERT INTO `dept` VALUES ('29', '计算机系', '网络工程');
INSERT INTO `dept` VALUES ('30', '美术系', '西方美术绘画');
INSERT INTO `dept` VALUES ('31', '体育系', '足球');
INSERT INTO `dept` VALUES ('32', '设计系', '环境设计');
INSERT INTO `dept` VALUES ('33', '书法系', '硬笔书法');
INSERT INTO `dept` VALUES ('34', '法律系', '宪法学');
INSERT INTO `dept` VALUES ('35', '马克思主义学院', '现代政治');
INSERT INTO `dept` VALUES ('36', '外语系', '日语');
INSERT INTO `dept` VALUES ('37', '物理系', '粒子构造');
INSERT INTO `dept` VALUES ('38', '生物系', '人体结构');
INSERT INTO `dept` VALUES ('39', '音乐系', '现代流行音乐');
INSERT INTO `dept` VALUES ('40', '舞蹈系', '舞蹈与生活');
INSERT INTO `dept` VALUES ('41', '管理系', '酒店管理');
INSERT INTO `dept` VALUES ('42', '影视艺术系', '影视特效');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(5) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `origin` varchar(25) DEFAULT NULL,
  `admissionSchool` varchar(20) DEFAULT NULL,
  `achievement` int(3) DEFAULT NULL,
  `chinese` int(3) DEFAULT NULL,
  `maths` int(3) DEFAULT NULL,
  `engllish` int(3) DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  `used` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '男', '广东广州', '番禺中学', '250', '95', '95', '70', '1', '1');
INSERT INTO `student` VALUES ('2', '李四', '男', '广东广州', '南沙中学', '210', '90', '70', '50', '13', '1');
INSERT INTO `student` VALUES ('3', '王五', '女', '湖南长沙', '长沙中学', '300', '100', '100', '100', '17', '1');
INSERT INTO `student` VALUES ('4', '赵六', '男', '上海市', '上海中学', '280', '95', '80', '75', '20', '1');
INSERT INTO `student` VALUES ('5', '何其正', '女', '北京市', '北京中学', '275', '90', '90', '95', '34', '1');
INSERT INTO `student` VALUES ('7', '石丹理', '男', '芜湖市', '芜湖中学', '230', '70', '80', '80', '26', '1');

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
