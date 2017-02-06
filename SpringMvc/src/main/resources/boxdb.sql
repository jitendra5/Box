CREATE TABLE `boxtable` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(45) NOT NULL,
   `weight` varchar(45) NOT NULL,
   `color` varchar(45) NOT NULL,
   `country` varchar(45) NOT NULL,
   `cost` float DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;