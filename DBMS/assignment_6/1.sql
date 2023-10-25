-- SQL Queries

1. select * from employee where EmpName like 'P%';

2. select count(salary) from EmpSalary where Ispermanent = 'Yes' and salary >= 5000;

3. select * from employee where EmailId like '%@gmail.com';

4. select * from employee where Department = 'E-104' or Department = 'E-102';

5.select DeptName from EmpDept where DeptId = 'E-102';

6. select sum(salary) from EmpSalary where Ispermanent = 'Yes';

7. select EmpName from employee where EmpName like '%a';

8. select count(EmpId), ProjectId from EmpProject group by ProjectId;

9. select count(ProjectId) from EmpProject where StartYear = 2010;

10.select count(ProjectId) from EmpProject where Startyear = EndYear;

11.select name from employee where name like '__h%';

12.select DeptName from employee as e join EmpDept as ed on e.department = ed.DeptId and e.Empid > 103;

13.select name from employee where EmpHeadId = (select Empid from employee where name = 'Abhishek');

14.select name from employee as e join EmpDept as ed on e.Empid = ed.DeptHead and ed.department = 'HR';

15.select name from employee where Empid in (select EmpHeadId from employee) and Empid in (select EmpId from EmpSalary where Ispermanent = 'Yes');

16.select name,email from employee where Empid in (select EmpHeadId from employee) and Empid not in (select EmpId from EmpSalary where Ispermanent = 'No');

17.select name from employee as e join EmpDept as ed on e.department = ed.DeptId and DeptOff = 'Monday';

18.select * from clientTable where cid in (select cid from Country where cname = 'India');

19.select * from employee where department in (select DeptId from EmpDept where DeptName = 'Development');

20.