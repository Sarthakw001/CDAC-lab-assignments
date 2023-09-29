create database college;
use college;
create table student(
    roll int,
    name varchar(15),
    marks float,
    age int
);

insert into student values (1,"Sarthak",100,23),(2,"Suryansh",95,23),(3,"Krishna",67,18),(4,"Akshat",90,22),(5,"Ankit",98,29);

select sum(marks) as total_marks from student;
select avg(marks) as average_marks from student;

select count(marks) as marks_greater_90 from student where marks > 90;
select count(age) as age_above_20 from student where age >= 20;

select max(marks) as max_marks from student;
select max(age) as max_age from student;

select min(age) as min_age from student;
select min(marks) as min_marks from student;

select distinct age from student;

select sum(marks),age from student group by age;

select count(age),age from student group by age;

select count(age),age from student group by age having count(age) > 1;

select name,age from student order by name asc;
select name,age from student order by age desc;

select * from student where roll in (1,3,5);
select * from student where roll not in (1,3,5);

select name from student where marks is not null;

select * from student where marks between 95 and 100;

select * from student where name like 'S%';