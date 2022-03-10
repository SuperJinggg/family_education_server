/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50734
Source Host           : 101.132.74.147:3306
Source Database       : teacher_pro

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2022-03-10 09:53:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book_order
-- ----------------------------
DROP TABLE IF EXISTS `book_order`;
CREATE TABLE `book_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `par_phone` varchar(11) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `counts` int(11) NOT NULL DEFAULT '0',
  `price` double(10,2) NOT NULL,
  `states` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_order
-- ----------------------------
INSERT INTO `book_order` VALUES ('2', '18860872155', '高中政治', '1', '40.00', '0');
INSERT INTO `book_order` VALUES ('3', '18890317476', '初中数学', '1', '40.00', '1');
INSERT INTO `book_order` VALUES ('4', '18890317476', '高中语文', '1', '50.00', '1');
INSERT INTO `book_order` VALUES ('6', '18860872155', '五年中考三年模拟(英语)', '3', '399.00', '0');
INSERT INTO `book_order` VALUES ('7', '18860872155', '五年高考三年模拟(物理)', '1', '84.00', '0');
INSERT INTO `book_order` VALUES ('8', '18860872155', '五年高考三年模拟(数学)', '2', '242.00', '0');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `par_phone` varchar(11) NOT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `teacher_phone` varchar(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `dates` date NOT NULL,
  `subject` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('2', '18860872155', '华罗庚', '888888', '不愧是数学大师，直呼666', '2021-10-09', '数学');
INSERT INTO `evaluate` VALUES ('3', '18890317476', '华罗庚', '888888', '听不懂但感觉很牛逼的样子', '2021-10-09', '数学');
INSERT INTO `evaluate` VALUES ('4', '18890317476', '特朗普', '250250', '老头好搞笑', '2021-10-09', '英语');
INSERT INTO `evaluate` VALUES ('5', '18860872155', '华罗庚', '888888', '123', '2021-11-01', '数学');
INSERT INTO `evaluate` VALUES ('9', '18860872155', '华罗庚', '888888', '666666666666', '2021-11-03', '数学');
INSERT INTO `evaluate` VALUES ('10', '18860872155', '华罗庚', '888888', '666不愧是数学大神', '2021-11-03', '数学');
INSERT INTO `evaluate` VALUES ('19', '1', '阮忠义', '999999', '66', '2021-11-26', '物理');

-- ----------------------------
-- Table structure for par_money
-- ----------------------------
DROP TABLE IF EXISTS `par_money`;
CREATE TABLE `par_money` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `par_phone` varchar(11) NOT NULL,
  `balance` double NOT NULL COMMENT '账户',
  `point` int(11) NOT NULL COMMENT '积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of par_money
-- ----------------------------
INSERT INTO `par_money` VALUES ('1', '18860872155', '959', '460');
INSERT INTO `par_money` VALUES ('2', '18890317476', '666666', '666');
INSERT INTO `par_money` VALUES ('4', '1', '378606', '40');
INSERT INTO `par_money` VALUES ('5', '14760870494', '9766', '0');
INSERT INTO `par_money` VALUES ('6', '18457402118', '999', '0');
INSERT INTO `par_money` VALUES ('7', '7', '0', '0');
INSERT INTO `par_money` VALUES ('8', 'wg0', '0', '0');
INSERT INTO `par_money` VALUES ('9', 'wg99', '0', '0');
INSERT INTO `par_money` VALUES ('10', '0922', '2000', '0');
INSERT INTO `par_money` VALUES ('11', '2', '0', '0');
INSERT INTO `par_money` VALUES ('12', '0915', '0', '0');
INSERT INTO `par_money` VALUES ('13', '8', '0', '0');
INSERT INTO `par_money` VALUES ('14', '9', '0', '0');
INSERT INTO `par_money` VALUES ('15', 't', '0', '0');
INSERT INTO `par_money` VALUES ('16', '2233', '0', '0');
INSERT INTO `par_money` VALUES ('17', '2', '0', '0');
INSERT INTO `par_money` VALUES ('18', '12', '0', '0');

-- ----------------------------
-- Table structure for par_reward
-- ----------------------------
DROP TABLE IF EXISTS `par_reward`;
CREATE TABLE `par_reward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `par_phone` varchar(11) NOT NULL,
  `cost` double NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of par_reward
-- ----------------------------
INSERT INTO `par_reward` VALUES ('1', '18860872155', '88', '2021-11-01');
INSERT INTO `par_reward` VALUES ('2', '18890317476', '150', '2021-10-23');
INSERT INTO `par_reward` VALUES ('5', '18860872155', '100', '2021-11-02');
INSERT INTO `par_reward` VALUES ('6', '18860872155', '200', '2021-11-03');
INSERT INTO `par_reward` VALUES ('9', '1', '50', '2021-11-18');
INSERT INTO `par_reward` VALUES ('10', '1', '50', '2021-11-18');
INSERT INTO `par_reward` VALUES ('11', '18860872155', '100', '2021-11-24');

-- ----------------------------
-- Table structure for parent
-- ----------------------------
DROP TABLE IF EXISTS `parent`;
CREATE TABLE `parent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `par_phone` varchar(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parent
-- ----------------------------
INSERT INTO `parent` VALUES ('1', '18860872155', 'abyss', null, '江苏省镇江市');
INSERT INTO `parent` VALUES ('2', '18890317476', 'atom', null, '湖南省湘潭市');
INSERT INTO `parent` VALUES ('4', '1', 'a', null, null);
INSERT INTO `parent` VALUES ('5', '14760870494', 'bluemoon', null, null);
INSERT INTO `parent` VALUES ('6', '18457402118', 'Sun87882245', null, null);
INSERT INTO `parent` VALUES ('7', '7', '2', null, null);
INSERT INTO `parent` VALUES ('8', 'wg0', '1', null, null);
INSERT INTO `parent` VALUES ('9', 'wg99', '1', null, null);
INSERT INTO `parent` VALUES ('10', '0922', '0922', null, null);
INSERT INTO `parent` VALUES ('13', '8', 'a', null, null);
INSERT INTO `parent` VALUES ('14', '9', 'a', null, null);
INSERT INTO `parent` VALUES ('15', 't', 'a', null, null);
INSERT INTO `parent` VALUES ('16', '2233', 'a', null, null);
INSERT INTO `parent` VALUES ('17', '2', 'a', null, null);
INSERT INTO `parent` VALUES ('18', '12', 'x', null, null);

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `par_phone` varchar(11) NOT NULL,
  `plan_content` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('4', '1', '回来了旅途太漂亮了咯呕吐了', '2021-12-01', '2021-12-12');
INSERT INTO `plan` VALUES ('5', '18860872155', '吐了空虚了卡册来了来了啦啊咯物体换回来了嗯摸鱼', '2021-12-01', '2021-12-03');
INSERT INTO `plan` VALUES ('6', '18860872155', '图OK几哈路路通咯哦呕吐咯莫哦分一下', '2021-12-25', '2021-12-26');

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `par_phone` varchar(11) NOT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `teacher_phone` varchar(11) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserve
-- ----------------------------
INSERT INTO `reserve` VALUES ('10', '18860872155', '华罗庚', '888888', '数学', '2021-10-21', '2021-10-22');
INSERT INTO `reserve` VALUES ('11', '18860872155', '华罗庚', '888888', '数学', '2021-11-03', '2021-11-04');
INSERT INTO `reserve` VALUES ('13', '14760870494', '毛泽东', '666666', '政治', '1949-09-03', '1949-09-18');
INSERT INTO `reserve` VALUES ('15', '18860872155', '毛泽东', '666666', '政治', '2011-06-12', '2014-08-24');
INSERT INTO `reserve` VALUES ('21', '1', '华罗庚', '888888', '数学', '2030-03-03', '2030-03-04');
INSERT INTO `reserve` VALUES ('22', '191919', 'Name', 'Phone', 'Subject', '2020-10-10', '2020-10-11');
INSERT INTO `reserve` VALUES ('23', '191919', 'Name', 'Phone', 'Subject', '2020-03-01', '2020-03-02');
INSERT INTO `reserve` VALUES ('24', '191919', 'Name', 'Phone', 'Subject', '2020-03-03', '2020-03-04');
INSERT INTO `reserve` VALUES ('25', '1', '鲁迅', '111111', '语文', '2021-11-25', '2021-11-25');
INSERT INTO `reserve` VALUES ('26', '1', '鲁迅', '111111', '语文', '1921-07-21', '1921-08-23');
INSERT INTO `reserve` VALUES ('27', '191919', 'Name', 'Phone', 'Subject', '2020-04-01', '2020-04-02');
INSERT INTO `reserve` VALUES ('28', '1', 'Name', 'Phone', 'Subject', '2020-10-01', '2020-10-02');
INSERT INTO `reserve` VALUES ('30', '1', 'Name', 'Phone', 'Subject', '2021-12-01', '2021-12-02');
INSERT INTO `reserve` VALUES ('31', '1', '毛泽东', '666666', '政治', '2020-01-07', '2020-01-08');
INSERT INTO `reserve` VALUES ('32', '1', '杨振宁', '999999', '物理', '2020-10-07', '2020-10-08');
INSERT INTO `reserve` VALUES ('33', '1', '杨振宁', '999999', '物理', '2000-10-01', '2000-10-02');
INSERT INTO `reserve` VALUES ('34', '1', '特朗普', '250250', '英语', '2020-05-08', '2020-05-09');
INSERT INTO `reserve` VALUES ('37', '0922', '华罗庚', '888888', '数学', '2030-06-06', '2030-06-07');
INSERT INTO `reserve` VALUES ('38', '0922', '鲁迅', '111111', '语文', '2030-09-04', '2030-09-05');
INSERT INTO `reserve` VALUES ('39', '1', '毛泽东', '666666', '政治', '2020-10-04', '2020-10-05');
INSERT INTO `reserve` VALUES ('40', '1', '特朗普', '250250', '英语', '2020-10-09', '2020-10-10');
INSERT INTO `reserve` VALUES ('41', '1', '杨靖宇', '666666', '政治', '2020-06-07', '2020-06-08');
INSERT INTO `reserve` VALUES ('42', '1', '汪曾祺', '111111', '语文', '2020-05-01', '2020-05-02');
INSERT INTO `reserve` VALUES ('44', '1', '阮忠义', '999999', '物理', '2020-04-04', '2020-04-05');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) NOT NULL,
  `teacher_sex` varchar(11) NOT NULL,
  `teacher_phone` varchar(11) NOT NULL,
  `teacher_address` varchar(255) NOT NULL,
  `teacher_icon` varchar(255) DEFAULT NULL,
  `teacher_exper` varchar(255) DEFAULT NULL,
  `subject` varchar(10) NOT NULL,
  `grade` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '杨靖宇', '男', '666666', '湖南省湘潭市韶山市', null, '伟大的政治家', '政治', '高中');
INSERT INTO `teacher` VALUES ('2', '奥巴马', '男', '250250', '美国华盛顿州', null, '英语风趣幽默，热爱讲相声', '英语', '初中,高中');
INSERT INTO `teacher` VALUES ('3', '阮忠义', '男', '999999', '北京市', null, '物理诺贝尔获得者，爱情与事业双收', '物理', '高中');
INSERT INTO `teacher` VALUES ('4', '田宇', '男', '888888', '上海市', null, '中国数学奠基者', '数学', '初中,高中');
INSERT INTO `teacher` VALUES ('5', '汪曾祺', '男', '111111', '上海市', null, '传奇的周树人', '语文', '初中,高中');
INSERT INTO `teacher` VALUES ('6', '王刚', '女', '222222', '宁波市', null, '青蒿素发现者', '化学,生物', '高中');
