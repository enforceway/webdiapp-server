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
-- Table structure for table `questionaire_question_r`
--

DROP TABLE IF EXISTS `questionaire_question_r`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionaire_question_r` (
  `id` int(11) NOT NULL COMMENT '主键',
  `question_type` int(11) NOT NULL COMMENT '题目类型: 1代表单选，2代表多选，3代表文本输入，4代表长文本输入',
  `question_id` int(11) NOT NULL COMMENT '题目的id',
  `questionaire_id` int(11) NOT NULL COMMENT '调查问卷的id',
  `enabled` int(11) DEFAULT NULL COMMENT '定义了该问题在问卷中是否启用：0代表未启动，1代表启用',
  `creation_timestamp` datetime DEFAULT NULL,
  `creation_user` int(11) DEFAULT NULL,
  `lastupdate_timestamp` datetime DEFAULT NULL,
  `lastupdate_user` int(11) DEFAULT NULL,
  `use_yn` varchar(5) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定义问卷中有哪些题目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionaire_question_r`
--

LOCK TABLES `questionaire_question_r` WRITE;
/*!40000 ALTER TABLE `questionaire_question_r` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionaire_question_r` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-11  1:17:06
