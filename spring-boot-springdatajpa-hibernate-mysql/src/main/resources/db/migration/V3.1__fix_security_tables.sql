DROP TABLE IF EXISTS `users`;

CREATE TABLE IF NOT EXISTS `users` (
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `enabled` BOOLEAN NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE IF NOT EXISTS `authorities`(
  `username` varchar(255) NOT NULL,
  `authority` varchar(255) NOT NULL,
  CONSTRAINT `fk_authorities_users`
  FOREIGN KEY(`username`) REFERENCES `users` (`username`),
  UNIQUE INDEX `authorities_idx` (`username`, `authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
