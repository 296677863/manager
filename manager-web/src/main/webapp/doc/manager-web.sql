/*
SQLyog 企业版 - MySQL GUI v8.14
MySQL - 5.5.49 : Database - oauth2_shiro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`manager-web` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `oauth_access_token` */

DROP TABLE IF EXISTS `oauth_access_token`;

CREATE TABLE `oauth_access_token` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token_expired_seconds` int(11) DEFAULT '-1',
  `authentication_id` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `token_type` varchar(255) DEFAULT NULL,
  `refresh_token_expired_seconds` int(11) DEFAULT '-1',
  `refresh_token` varchar(255) DEFAULT NULL,
  UNIQUE KEY `token_id` (`token_id`),
  UNIQUE KEY `refresh_token` (`refresh_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `oauth_client_details` */

DROP TABLE IF EXISTS `oauth_client_details`;

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `client_name` varchar(255) DEFAULT NULL,
  `client_uri` varchar(255) DEFAULT NULL,
  `client_icon_uri` varchar(255) DEFAULT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `grant_types` varchar(255) DEFAULT NULL,
  `redirect_uri` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT '-1',
  `refresh_token_validity` int(11) DEFAULT '-1',
  `description` varchar(4096) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `archived` tinyint(1) DEFAULT '0',
  `trusted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `oauth_code` */

DROP TABLE IF EXISTS `oauth_code`;

CREATE TABLE `oauth_code` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `code` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guid` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `archived` tinyint(1) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `guid` (`guid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Table structure for table `roles_permissions` */

DROP TABLE IF EXISTS `roles_permissions`;

CREATE TABLE `roles_permissions` (
  `roles_id` int(11) NOT NULL,
  `permission` varchar(255) NOT NULL,
  KEY `roles_id_index` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `users_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  KEY `users_id_index` (`users_id`),
  KEY `roles_id_index` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guid` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `archived` tinyint(1) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `default_user` tinyint(1) DEFAULT '0',
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `guid` (`guid`),
  UNIQUE KEY `username` (`username`),
  KEY `username_index` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
