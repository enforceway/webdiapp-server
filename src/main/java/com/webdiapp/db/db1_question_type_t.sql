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
-- Table structure for table `question_type_t`
--

DROP TABLE IF EXISTS `question_type_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_type_t` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL COMMENT '定义了题目所属领域',
  `creation_timestamp` datetime DEFAULT NULL,
  `creation_user` int DEFAULT NULL,
  `lastupdate_timestamp` datetime DEFAULT NULL,
  `lastupdate_user` int DEFAULT NULL,
  `use_yn` varchar(5) DEFAULT 'y' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_type_t`
--

LOCK TABLES `question_type_t` WRITE;
/*!40000 ALTER TABLE `question_type_t` DISABLE KEYS */;
INSERT INTO `question_type_t` VALUES (1,'Sociology','2019-03-22 17:33:12',0,'2019-03-22 17:33:12',0,'y'),(2,'Industry','2019-03-22 17:34:12',0,'2019-03-22 17:34:12',0,'y'),(3,'Computer & Science','2019-03-22 17:34:23',0,'2019-03-22 17:34:23',0,'y'),(4,'Art','2019-03-22 17:34:30',0,'2019-03-22 17:34:30',0,'y'),(5,'Art & Literature','2019-03-22 17:34:47',0,'2019-03-22 17:34:47',0,'y'),(6,'Sports','2019-03-22 17:35:00',0,'2019-03-22 17:35:00',0,'y'),(7,'News & Media','2019-03-22 17:35:10',0,'2019-03-22 17:35:10',0,'y'),(8,'Psychology','2019-03-22 17:35:45',0,'2019-03-22 17:35:45',0,'y'),(9,'Medical science','2019-03-22 17:36:26',0,'2019-03-22 17:36:26',0,'y'),(10,'Language','2019-03-22 17:37:03',0,'2019-03-22 17:37:03',0,'y'),(11,'Zoology','2019-03-22 18:19:19',0,'2019-03-22 18:19:19',0,'y'),(12,'Entomology','2019-03-22 18:24:02',0,'2019-03-22 18:24:02',0,'y'),(13,'Oceanography','2019-03-22 18:25:28',0,'2019-03-22 18:25:28',0,'y'),(14,'Metaphysics','2019-03-22 18:30:43',0,'2019-03-22 18:30:43',0,'y'),(15,'Physics','2019-03-22 18:31:08',0,'2019-03-22 18:31:08',0,'y'),(16,'Geometry','2019-03-22 18:31:25',0,'2019-03-22 18:31:25',0,'y'),(17,'Discrete mathematics','2019-03-22 18:31:48',0,'2019-03-22 18:31:48',0,'y'),(18,'Chemistry','2019-03-22 18:32:19',0,'2019-03-22 18:32:19',0,'y'),(19,'Mechanics','2019-03-22 18:33:04',0,'2019-03-22 18:33:04',0,'y'),(20,'Kinetics','2019-03-22 18:33:20',0,'2019-03-22 18:33:20',0,'y'),(21,'Cosmography','2019-03-22 18:33:56',0,'2019-03-22 18:33:56',0,'y');
/*!40000 ALTER TABLE `question_type_t` ENABLE KEYS */;
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
