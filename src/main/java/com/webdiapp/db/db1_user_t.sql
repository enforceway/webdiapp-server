DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `creation_timestamp` datetime DEFAULT NULL,
  `creation_user` int DEFAULT NULL,
  `creation_username` varchar(45) DEFAULT NULL,
  `lastupdate_timestamp` datetime DEFAULT NULL,
  `lastupdate_user` int DEFAULT NULL,
  `lastupdate_username` varchar(45) DEFAULT NULL,
  `use_yn` varchar(5) DEFAULT 'y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;