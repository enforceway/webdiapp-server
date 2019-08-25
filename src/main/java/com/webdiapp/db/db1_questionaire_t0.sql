-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: db1
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `questionaire_t`
--

DROP TABLE IF EXISTS `questionaire_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `questionaire_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL COMMENT '问卷的主题.',
  `status_id` int(11) DEFAULT NULL COMMENT '定义了状态',
  `creation_timestamp` timestamp NULL DEFAULT NULL,
  `creation_user` int(11) DEFAULT NULL,
  `lastupdate_timestamp` timestamp NULL DEFAULT NULL,
  `lastupdate_user` int(11) DEFAULT NULL,
  `active_date_start` timestamp NULL DEFAULT NULL COMMENT '开始有效日期',
  `active_date_end` timestamp NULL DEFAULT NULL COMMENT '结束有效日期',
  `use_yn` varchar(5) DEFAULT 'y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='问卷对应的数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionaire_t`
--

LOCK TABLES `questionaire_t` WRITE;
/*!40000 ALTER TABLE `questionaire_t` DISABLE KEYS */;
INSERT INTO `questionaire_t` VALUES (2,'初学者入试教程',1,'2019-08-11 08:25:11',NULL,'2019-08-11 08:25:11',NULL,'2019-07-31 11:00:00','2019-08-28 11:00:00','y');
/*!40000 ALTER TABLE `questionaire_t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-18 11:26:49
