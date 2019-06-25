/*
SQLyog - Free MySQL GUI v5.15
Host - 5.5.5-10.1.21-MariaDB : Database - watermark
*********************************************************************
Server version : 5.5.5-10.1.21-MariaDB
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `watermark`;

USE `watermark`;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `dupimages` */

DROP TABLE IF EXISTS `dupimages`;

CREATE TABLE `dupimages` (
  `Fileid` varchar(40) DEFAULT NULL,
  `Filename` varchar(100) DEFAULT NULL,
  `OldFileid` varchar(30) DEFAULT NULL,
  `Comment` varchar(300) DEFAULT NULL,
  `Imagetype` varchar(200) DEFAULT NULL,
  `Macaddress` varchar(30) DEFAULT NULL,
  `status` varchar(202) DEFAULT NULL,
  `uploadstatus` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `postedimages` */

DROP TABLE IF EXISTS `postedimages`;

CREATE TABLE `postedimages` (
  `Fileid` varchar(20) DEFAULT NULL,
  `Filename` varchar(303) DEFAULT NULL,
  `Storedname` varchar(303) DEFAULT NULL,
  `Comment` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `profileimages` */

DROP TABLE IF EXISTS `profileimages`;

CREATE TABLE `profileimages` (
  `Fileid` varchar(303) DEFAULT NULL,
  `Filename` varchar(403) DEFAULT NULL,
  `Storedname` varchar(453) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `mail` varchar(202) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `SecurityQuestion` varchar(300) DEFAULT NULL,
  `Answer` varchar(303) DEFAULT NULL,
  `Macaddress` varchar(305) DEFAULT NULL,
  `Permit` varchar(200) DEFAULT NULL,
  `otp` varchar(33) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET SQL_MODE=@OLD_SQL_MODE;