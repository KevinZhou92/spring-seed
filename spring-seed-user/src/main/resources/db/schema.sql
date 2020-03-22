-- Create spring_seed database
CREATE DATABASE
IF NOT EXISTS `spring_seed` DEFAULT CHARSET utf8 COLLATE utf8_bin;

-- Select spring_seed
USE spring_seed;

-- Create user table
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE
IF EXISTS `user`;
CREATE TABLE `user` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR ( 255 ) COLLATE utf8_bin NOT NULL,
	`first_name` VARCHAR ( 255 ) COLLATE utf8_bin DEFAULT NULL,
    `last_name` VARCHAR ( 255 ) COLLATE utf8_bin DEFAULT NULL,
    `email` VARCHAR ( 255 ) COLLATE utf8_bin DEFAULT NULL,
	`password` VARCHAR ( 255 ) COLLATE utf8_bin NOT NULL,
	`salt` VARCHAR ( 255 ) COLLATE utf8_bin DEFAULT NULL,
	PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
SET FOREIGN_KEY_CHECKS = 1;
