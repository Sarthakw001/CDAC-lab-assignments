create database college;
use college;
create table student(
    roll int,
    name varchar(15),
    marks float,
    age int
);



insert into student values (1,"Sarthak",100,24);
insert into student values (2,"Suryansh",95,23);
insert into student values (3,"Krishna",67,18);
insert into student values (4,"Akshat",90,22);
insert into student values (5,"Ankit",98,29);

select * from student;

delete from student where roll = 4;

update student set marks = marks + 0.5;

truncate table student;

insert into student values (1,"Sarthak",100,24),(2,"Suryansh",95,23),(3,"Krishna",67,18),(4,"Akshat",90,22),(5,"Ankit",98,29);
