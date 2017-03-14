ALTER TABLE `person` MODIFY `username` VARCHAR(50) NOT NULL;
ALTER TABLE `person` MODIFY `password` VARCHAR(255) NOT NULL;

CREATE TABLE `authorities` (    
	`username` VARCHAR(50) NOT NULL,    
	`authority` VARCHAR(50) NOT NULL,    
	FOREIGN KEY (`username`) references `person` (`username`),    
	UNIQUE INDEX `authorities_idx` (`username`, `authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;   
