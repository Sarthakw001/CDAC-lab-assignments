create database college;
use college;
create table student (
    roll int,
    name varchar(15),
    marks float,
    age int
);

desc student;
alter table student modify marks int;
alter table student drop age;

show tables;
truncate table student;
drop table student;
drop database college;
