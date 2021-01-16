-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db1
-- ------------------------------------------------------
-- Server version	5.6.38-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
use db1;
--
-- Table structure for table `question_t`
--

DROP TABLE IF EXISTS `question_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_content` varchar(255) NOT NULL COMMENT '定义了题目带内容',
  `question_type_id` int(11) DEFAULT NULL COMMENT '题目对应的类型id',
  `question_type` varchar(55) DEFAULT 'sociology' COMMENT '题目对应带类型显示文字',
  `creation_timestamp` datetime DEFAULT NULL,
  `creation_user` int(11) DEFAULT NULL,
  `lastupdate_timestamp` datetime DEFAULT NULL,
  `lastupdate_user` int(11) DEFAULT NULL,
  `use_yn` varchar(5) DEFAULT 'y' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COMMENT='题目对应的表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_t`
--

LOCK TABLES `question_t` WRITE;
/*!40000 ALTER TABLE `question_t` DISABLE KEYS */;
INSERT INTO `question_t` VALUES (1,'你热爱此前的工作吗?',1,'Sociology','2019-03-22 19:44:08',NULL,'2019-03-22 19:46:11',0,NULL),(19,'个人工作经验，也就是自己的背景介绍',1,'Sociology','2019-03-22 19:44:08',NULL,'2019-03-22 19:46:11',NULL,NULL),(20,'公司为什么要选择你，证明过往经历适合该岗位',1,'Sociology','2019-03-22 19:44:08',NULL,'2019-03-22 19:46:11',NULL,NULL),(21,'为什么要选择这家公司',1,'Sociology','2019-03-22 19:44:08',NULL,'2019-03-22 19:46:11',NULL,NULL),(22,'今天是 一个晴朗的日子吗？',NULL,'4','2019-04-15 10:04:56',0,'2019-04-15 10:04:56',0,NULL),(23,'男的的吗？带带带带带',NULL,'2','2019-04-15 10:06:32',0,'2019-04-15 10:06:32',0,NULL),(24,'dfdfd',NULL,'2','2019-04-15 10:08:27',0,'2019-04-15 10:08:27',0,NULL),(25,'asdfg',NULL,'2','2019-04-15 10:19:48',0,'2019-04-15 10:19:48',0,NULL),(26,'asfdasdf',2,'Industry','2019-04-15 10:24:47',0,'2019-04-15 10:24:47',0,NULL),(27,'今天是晴朗的一天？',2,'Computer & Science','2019-04-18 16:02:14',0,'2019-04-18 16:05:28',0,NULL);
/*!40000 ALTER TABLE `question_t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-11  1:17:04
