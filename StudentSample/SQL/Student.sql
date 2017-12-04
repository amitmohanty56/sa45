CREATE TABLE student (
      id bigint AUTO_INCREMENT NOT NULL,
      name varchar(255),
      nick varchar(255),
      course varchar(255),
PRIMARY KEY(id),
INDEX student_id_INDEX (id));
INSERT INTO `sa45demo`.`student` (`name`, `nick`, `course`) VALUES ('Ms.H2O', 'Water', 'Java');
INSERT INTO `sa45demo`.`student` (`name`, `nick`, `course`) VALUES ('Ms.Charolette', 'Cute', 'Java');
INSERT INTO `sa45demo`.`student` (`name`, `nick`, `course`) VALUES ('Mr.Urmi', 'Mi', 'Java');
