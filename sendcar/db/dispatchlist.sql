# Host: localhost  (Version 5.5.53)
# Date: 2018-03-24 16:27:15
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "department"
#

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ctime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "department"
#

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,0,'宣传部','2018-03-22 19:05:54'),(12,0,'办公室','2018/03/23 00:14'),(13,0,'技术部','2018/03/24 11:24'),(14,0,'财务部','2018/03/24 11:25'),(15,0,'市场部','2018/03/24 11:25'),(16,0,'董事会','2018/03/24 11:26');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

#
# Structure for table "dispatchlist"
#

DROP TABLE IF EXISTS `dispatchlist`;
CREATE TABLE `dispatchlist` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `dep` varchar(255) DEFAULT NULL,
  `gotime` varchar(255) DEFAULT NULL,
  `length` float NOT NULL DEFAULT '0',
  `manager` varchar(255) DEFAULT NULL,
  `people` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `time` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "dispatchlist"
#

/*!40000 ALTER TABLE `dispatchlist` DISABLE KEYS */;
INSERT INTO `dispatchlist` VALUES ('20180002','花都预付','2018-03-22 17:44:58','111','2018-12-12',12,'111','张三','啦啦啦',1),('20180004','','2018/03/23 00:05','','',0,'','','',0),('20180006','战绩是','2018/03/24 11:01','宣传部','2018/03/29 10:53',6,'战绩是','宛菡','喝酒',6),('20180010','1111','2018/03/24 16:16','宣传部','2018/03/06 16:16',2,'战绩是','1111','1111',22),('20180011',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0),('20180012',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0),('20180013',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0),('20180014',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0),('20180015',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `dispatchlist` ENABLE KEYS */;

#
# Structure for table "manager"
#

DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "manager"
#

/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (2,'admin','admin','北京市海淀区','1222','蓝海科技',0),(3,'admin','admin','11111','1111','1111',0),(4,'admin','admin','111','111','1111',0);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (38,NULL,NULL,NULL),(39,'张家口',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
