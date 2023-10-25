-- Assignment 5 : 

********************************************************************************************************************** 

 1. select first_name as worker_name from worker;

 2. select upper(first_name) as first_name_in_upperCase from worker;

 3. Select distinct department from worker;

 4. select left(first_name,3) as first_3_char from worker;

 5. select position('a' in first_name) as position_of_a from worker where first_name = 'Amitabh';

 6. select first_name from worker order by first_name asc;

 7. select first_name,department from worker order by first_name asc , department desc;

 8. select * from worker where first_name in('vipul','satish');

 9. select * from worker where first_name not in('vipul','satish');

10. select * from worker where department = 'admin';

11. select * from worker where first_name like ('%a%');

12. select * from worker where first_name like('%a');

13. select * from worker where first_name like ("_____h");

14. select * from worker where salary > 100000 and salary < 500000;

15. select * from worker where year(joining_date) = 2021 and month(joining_date) = 2;

16. select count(first_name) as admin_count from worker where department = "admin";

17. select * from worker where salary between 50000 and 100000;

18. select department, count(department) from worker group by department order by count(department) desc;

19. select * from worker w inner join title t on w.worker_id = t.worker_ref_id and t.worker_title in ("Manager");

20. select worker_title, count(worker_title) from title group by worker_title having count(worker_title) > 1;

21. select * from worker where mod(worker_id,2) <> 0;

22. select * from worker where mod(worker_id,2) = 0;

23. create table workerClone like worker;

24. select w.first_name,w.last_name,w.salary,b.bonus_amount from worker as w inner join bonus as b on w.worker_id = b.worker_ref_id;

25.  select * from worker as w left join bonus as b on w.worker_id = b.worker_ref_id;

26. select * from worker order by salary desc limit 6;

27. select w.first_name,w.last_name from worker w inner join worker w1 on w.salary = w1.salary and w.worker_id <> w1.worker_id;

28. select max(salary) from worker where salary not in (select max(salary) from worker); -- select min(salary) from (select distinct salary from worker order by ,salary desc) where rownum < 3;

29. select * from worker as w inner join bonus as b on w.worker_id = b.worker_ref_id;

30. select * from worker where worker_id <= (select count(worker_id)/2 from worker);

31. select department from worker group by department having count(department) < 5;

32. select department,count(department) as Number_of_people from worker group by department;

33. select * from worker where worker_id = (select count(worker_id) from worker);

34. select * from worker where worker_id = (select count(worker_id)-(count(worker_id)-1) from worker);

35. select * from worker where worker_id > (select count(worker_id)-5 from worker);

36. select first_name,last_name from worker w where 

37. select top 3 salary from worker order by salary desc;

38. select department,sum(salary) from worker group by department; 

39.select first_name,last_name,salary from worker where salary = (select max(salary) from worker);



****************************************************************************************************************