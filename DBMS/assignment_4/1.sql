 -- Assignment 4 : 

 -- *****************************************************************************************************************************************************************************

1.select emp_details.name,emp_details.birth, dept_detail.dept_name,dept_detail.dept_block from emp_details join dept_detail on dept_detail.dept_id = emp_details.dept_id;

2. select name from student where name like "____a";

3. select name, year(curdate()) - year(birth) as student_age from students;

4. Questions regarding employee and reward table;
   
	1. select * from employee;
	2. select First_name, Last_name from employee;
	3. select First_name as Employee_name from employee;
	4. select lower(Last_name) from employee;
	5. select upper(Last_name) from employee;
	6. select distinct Department from employee;
	7. select left(First_name,4) from employee;
	8. select position('h' in First_name) from employee where First_name = "John";
	9. select rtrim(First_name) as first_name from employee;
   10. select ltrim(First_name) as first_name from employee; 
   11. create table employee (employee_id int primary key, first_name varchar(20), last_name varchar(20), salary int, joining_date date, department varchar(20));

-- ******************************************************************************************************************************************************