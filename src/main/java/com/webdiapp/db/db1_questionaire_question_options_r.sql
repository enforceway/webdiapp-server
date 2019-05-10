-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db1
-- ------------------------------------------------------
-- Server version	5.6.38-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `questionaire_question_options_r`
--

DROP TABLE IF EXISTS `questionaire_question_options_r`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionaire_question_options_r` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionire_question_id` int(11) DEFAULT NULL COMMENT '定义了问卷中问题的id',
  `option_content` varchar(255) DEFAULT NULL COMMENT '定义了每个选项对应带文字内容',
  `selected` int(11) DEFAULT '0' COMMENT '定义了题目对应带多个选项中，哪个被选中:0代表未选中，1代表选中。',
  `creation_timestamp` datetime DEFAULT NULL,
  `creation_user` int(11) DEFAULT NULL,
  `use_yn` varchar(5) DEFAULT 'y' COMMENT '标识问卷中该题目是否禁用，不在真是问卷中使用。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='问卷中题目对应带选项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionaire_question_options_r`
--

LOCK TABLES `questionaire_question_options_r` WRITE;
/*!40000 ALTER TABLE `questionaire_question_options_r` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionaire_question_options_r` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-11  1:17:05
