DROP DATABASE IF EXISTS stud;
CREATE DATABASE stud DEFAULT CHARACTER SET 'utf8';
USE stud;
create table students
(
  surname varchar(30),
  _name varchar(30),
  fname varchar(30),
  student_id int not null auto_increment,
  group_id int not null,
  primary key (student_id)
) engine=InnoDB;
create table groups
(
  group_id int not null auto_increment,
  group_name varchar(10),
  spec_id int not null,
  primary key (group_id)
) engine=InnoDB;
create table specialty
(
  spec_id int not null auto_increment,
  spec_code varchar(20),
  spec_name varchar(150),
  faculty_id int not null,
  primary key (spec_id)
) engine=InnoDB;
create table faculty
(
  faculty_id int not null auto_increment,
  faculty_name varchar(70),
  primary key (faculty_id)
) engine=InnoDB;

alter table specialty
	add constraint FK_SPECIALTY_FACULTY
	foreign key (faculty_id)
	references faculty(faculty_id);

alter table groups
	add constraint FK_GROUPS_SPECIALITY
	foreign key (spec_id)
	references specialty(spec_id);

alter table students
	add constraint FK_STUDENTS_GROUPS
	foreign key (group_id)
	references groups(group_id);

set names 'utf8';
insert into faculty (faculty_name) 
values ('Розробка ПЗ');
insert into specialty (spec_code, spec_name, faculty_id) 
values ('PI0596045', 'Програмна інженерія', 1);
insert into groups (group_name, spec_id)
values ('ПІ-11-01', 1);
insert into groups (group_name, spec_id)
values ('ПІ-11-02', 1);
insert into students (surname, _name, fname, group_id)
values ('Пупкін', 'Василь', 'Васильович',1);
insert into students (surname, _name, fname, group_id)
values ('Лящ', 'Віктор', 'Вікторович',1);
insert into students (surname, _name, fname, group_id)
values ('Цап', 'Андрій', 'Петрович',2);

