package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.ProjectDao;
import com.app.dao.ProjectDaoImpl;
import com.app.pojos.Project;

public class AssignEmpProject {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			ProjectDao dao=new ProjectDaoImpl();
			System.out.println("Enter emp id");
			Long empId=sc.nextLong();
			System.out.println("Enter project details : tittle,end_date, start_date ");
			System.out.println(dao.assignEmpProject
					(empId, new Project((sc.next()), LocalDate.parse(sc.next()),LocalDate.parse(sc.next()))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
