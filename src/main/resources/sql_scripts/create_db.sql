CREATE DATABASE  IF NOT EXISTS `zoo`;
USE `zoo`;

DROP TABLE IF EXISTS `animal`;
DROP TABLE IF EXISTS `disease`;
DROP TABLE IF EXISTS `animal_disease`;

CREATE TABLE `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(100) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `age` int(10) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `disease` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `animal_disease` (
  `animal_id` int(11) NOT NULL,
  `disease_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;