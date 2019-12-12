-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: db1
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `question_t`
--

DROP TABLE IF EXISTS `question_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_content` varchar(255) NOT NULL COMMENT '定义了题目带内容',
  `question_type_id` int(11) DEFAULT NULL COMMENT '题目对应的类型id',
  `question_type` varchar(55) DEFAULT 'sociology' COMMENT '题目对应带类型显示文字',
  `creation_timestamp` timestamp NULL DEFAULT NULL,
  `creation_user` int(11) DEFAULT NULL,
  `lastupdate_timestamp` timestamp NULL DEFAULT NULL,
  `lastupdate_user` int(11) DEFAULT NULL,
  `use_yn` varchar(5) DEFAULT 'y' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='题目对应的表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_t`
--

LOCK TABLES `question_t` WRITE;
/*!40000 ALTER TABLE `question_t` DISABLE KEYS */;
INSERT INTO `question_t` VALUES (36,'拥有国际互',1,'Sociology','2019-12-09 22:48:48',NULL,'2019-12-09 22:48:48',NULL,'n'),(37,'大浪华',1,'Sociology','2019-12-09 23:01:45',NULL,'2019-12-09 23:01:45',NULL,'y'),(38,'兰花一丢哦度哦',2,'Industry','2019-12-09 23:02:11',NULL,'2019-12-09 23:02:11',NULL,'y'),(39,'篮球最近刚经验',3,'Computer & Science','2019-12-09 23:02:21',NULL,'2019-12-09 23:02:21',NULL,'y'),(40,'mdon',1,'Sociology','2019-12-09 23:02:33',NULL,'2019-12-09 23:02:33',NULL,'y'),(42,'手打哦并没有满足',3,'Computer & Science','2019-12-09 23:02:48',NULL,'2019-12-09 23:02:48',NULL,'y'),(43,'从哪里来到哪里去',1,'Sociology','2019-12-09 23:02:58',NULL,'2019-12-09 23:02:58',NULL,'y'),(44,'生活无法是从',4,'Art','2019-12-09 23:03:10',NULL,'2019-12-09 23:03:10',NULL,'y');
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

-- Dump completed on 2019-12-12 14:44:23
