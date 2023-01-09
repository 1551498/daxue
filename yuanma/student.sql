/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.31 : Database - stu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stu` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `stu`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `name` varchar(5) COLLATE utf8mb3_bin DEFAULT NULL,
  `username` varchar(20) COLLATE utf8mb3_bin DEFAULT NULL,
  `userpassword` varchar(20) COLLATE utf8mb3_bin DEFAULT NULL,
  `sex` varchar(1) COLLATE utf8mb3_bin DEFAULT NULL,
  `exit` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `student` */

insert  into `student`(`name`,`username`,`userpassword`,`sex`,`exit`) values 
('小花','xiaohua','12345','女',0),
('小白','xiaobai','1234','男',0),
('小虎','xiaohu','2257','男',0),
('小龙','xiaolong','2257','男',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
