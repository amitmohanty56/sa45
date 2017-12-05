CREATE DATABASE `caps` ;


use caps;
CREATE TABLE `user` (
  `userID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userid_UNIQUE` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `administrator` (
  `adminID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`adminID`),
  UNIQUE KEY `adminID_UNIQUE` (`adminID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `lecturer` (
  `lecturerID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) unsigned NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lecturerID`),
  UNIQUE KEY `lecturerID_UNIQUE` (`lecturerID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  CONSTRAINT `user_ID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `student` (
  `studentID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(11) unsigned NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`studentID`),
  UNIQUE KEY `studentID_UNIQUE` (`studentID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  CONSTRAINT `student_userID_user` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `course` (
  `courseID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `courseCode` varchar(45) DEFAULT NULL,
  `courseName` varchar(45) DEFAULT NULL,
  `classSize` int(11) DEFAULT NULL,
  `lecturerID` int(11) NOT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `enrollSize` int(11) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseID`),
  UNIQUE KEY `courseID_UNIQUE` (`courseID`),
  KEY `lecturerID_idx` (`lecturerID`),
  CONSTRAINT `lecturerID` FOREIGN KEY (`lecturerID`) REFERENCES `lecturer` (`lecturerID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;


CREATE TABLE `enrollment` (
  `enrollmentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courseID` int(10) unsigned NOT NULL,
  `studentID` int(10) unsigned NOT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `credit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`enrollmentID`),
  UNIQUE KEY `enrollmentID_UNIQUE` (`enrollmentID`),
  KEY `courseID_idx` (`courseID`),
  KEY `studentID_idx` (`studentID`),
  CONSTRAINT `courseID` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studentID` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('1', 'ms.water', 'password', 'student');
INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('2', 'ms.cute', 'password', 'student');
INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('3', 'ms.mi', 'password', 'student');
INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('4', 'mr.quiet', 'password', 'student');
INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('5', 'mr.questions', 'password', 'student');

INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('6', 'boonkui', 'boonkui123', 'lecturer');
INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('7', 'zhimin', 'zhimin123', 'lecturer');
INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('8', 'yuenkwan', 'yuenkwan123', 'lecturer');
INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('9', 'derek', 'derek123', 'lecturer');
INSERT INTO `caps`.`user` (`userID`, `userName`, `password`, `role`) 
VALUES ('10', 'suria', 'suria123', 'administrator');

INSERT INTO `caps`.`lecturer` (`lecturerID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`) 
VALUES ('1', '6', 'Boon Kui', 'Heng', 'issboonkui@nus.edu.sg', '63840351', 'nus');
INSERT INTO `caps`.`lecturer` (`lecturerID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`) 
VALUES ('2', '7', 'Zhi Min', 'Choo', 'issczm@nus.edu.sg', '63840352', 'nus');
INSERT INTO `caps`.`lecturer` (`lecturerID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`) 
VALUES ('3', '8', 'Yuen Kwan', 'Chia', 'isscyk@nus.edu.sg', '63840353', 'nus');
INSERT INTO `caps`.`lecturer` (`lecturerID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`) 
VALUES ('4', '9', 'Derek', 'Kiong', 'isskbk@nus.edu.sg', '63840354', 'nus');


INSERT INTO `caps`.`student` (`studentID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`) 
VALUES ('1', '1', 'HTOO', 'EI EI KHAING', 'h2o@nus.edu.com', '12345678', 'tampines');
INSERT INTO `caps`.`student` (`studentID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`)
VALUES ('2', '2', 'CHEN', 'QIANYU', 'cq@nus.edu.com', '12345678', 'bukit panjang');
INSERT INTO `caps`.`student` (`studentID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`) 
VALUES ('3', '3', 'URMILA', 'KRISHNAMURTHY', 'um@nus.edu.com', '12345678', 'clementi');
INSERT INTO `caps`.`student` (`studentID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`) 
VALUES ('4', '4', 'MIKI', 'RUSLY', 'mr@nus.edu.com', '12345678', 'serangoon');
INSERT INTO `caps`.`student` (`studentID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`) 
VALUES ('5', '5', 'LIM', 'CHANG SIANG', 'lcs@nus.edu.com', '12345678', 'kent ridge');


INSERT INTO `caps`.`administrator` (`adminID`, `userID`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`) 
VALUES ('1', '10', 'Suriya', 'Priya', 'issspa@nus.edu.sg', '63840355', 'nus');


INSERT INTO `caps`.`course` (`courseID`, `courseCode`, `courseName`, `classSize`, `lecturerID`, `startDate`, `endDate`, `enrollSize`,`credit`) 
VALUES ('1', 'OOAD', 'OOAD', '20', '1', '2016-01-01', '2016-06-01', '2', '6');
INSERT INTO `caps`.`course` (`courseID`, `courseCode`, `courseName`, `classSize`, `lecturerID`, `startDate`, `endDate`, `enrollSize`,`credit`) 
VALUES ('2', 'JAVA1', 'JAVA Programming', '20', '2', '2016-01-01', '2016-06-01', '3', '6');
INSERT INTO `caps`.`course` (`courseID`, `courseCode`, `courseName`, `classSize`, `lecturerID`, `startDate`, `endDate`, `enrollSize`,`credit`) 
VALUES ('3', 'JAVA2', 'Web Development Using Spring', '20', '2', '2016-06-01', '2016-12-01', '1', '6');
INSERT INTO `caps`.`course` (`courseID`, `courseCode`, `courseName`, `classSize`, `lecturerID`, `startDate`, `endDate`, `enrollSize`,`credit`) 
VALUES ('4', 'SQL', 'SQL Programming', '20', '3', '2016-01-01', '2016-06-01', '1', '6');
INSERT INTO `caps`.`course` (`courseID`, `courseCode`, `courseName`, `classSize`, `lecturerID`, `startDate`, `endDate`, `enrollSize`,`credit`) 
VALUES ('5', 'WNET', 'Web Development Using ASP', '20', '4', '2016-01-01', '2016-06-01', '3', '6');


INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('1', '5', '5', 'F', '0');

INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('2', '5', '2', 'F', '0');

INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('3', '5', '1', 'F', '0');

INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('4', '4', '4', 'A', '6');

INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('5', '3', '4', 'A', '6');

INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('6', '2', '3', 'F', '0');

INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('7', '2', '2', 'B', '6');

INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('8', '2', '1', 'A', '6');

INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('9', '1', '2', 'C', '6');

INSERT INTO `caps`.`enrollment` (`enrollmentID`, `courseID`, `studentID`, `grade`, `credit`) 
VALUES ('10', '1', '1', 'A', '6');
