CREATE TABLE IF NOT EXISTS `person` (
  `id`       BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30)  NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `name`     VARCHAR(30)  DEFAULT NULL,
  `age` 	 INT(11)	  DEFAULT NULL,
  `guid`	 VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ukey_username` (`username`),
  UNIQUE KEY `ukey_guid` (`guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

