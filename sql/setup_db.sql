DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `number_of_points` TINYINT(101) DEFAULT NULL
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');

CREATE TABLE `members` (
  `user_id` varchar(50) Not null,
  `pw` char(68) Not null,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

INSERT INTO `members` VALUES
('john', '{bcrypt}$2a$12$/iEqUK1WIadDJ77yQve3j.ldq3278ywHqD.yIgAqag6O8pIYcBj0m', 1),
('mary', '{bcrypt}$2a$12$/iEqUK1WIadDJ77yQve3j.ldq3278ywHqD.yIgAqag6O8pIYcBj0m', 1),
('susan', '{bcrypt}$2a$12$/iEqUK1WIadDJ77yQve3j.ldq3278ywHqD.yIgAqag6O8pIYcBj0m', 1)

CREATE TABLE `roles` (
`user_id` varchar(50) not null,
`role` varchar(50) not null,
unique key `authorities_idx_1` (`user_id`, `role`),
constraint `authorities_ibfk_1`
foreign key (`user_id`)
references `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO roles VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');


