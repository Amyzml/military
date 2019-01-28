CREATE DATABASE /*!32312 IF NOT EXISTS */ `demo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `demo`;

DROP TABLE IF EXISTS `demo`;
CREATE TABLE demo
(
  id        VARCHAR(64)    PRIMARY KEY,
  name                   VARCHAR(255) unique key ,
  extra                  text,
  phone                  VARCHAR(255)            NOT NULL,
  create_time            datetime                NOT NULL,
  update_time            datetime
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
