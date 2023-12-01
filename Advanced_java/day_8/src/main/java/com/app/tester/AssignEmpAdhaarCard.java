package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.AdhaarCardDao;
import com.app.dao.AdhaarCardDaoImpl;

import com.app.pojos.AdhaarCard;

public class AssignEmpAdhaarCard {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			AdhaarCardDao dao=new AdhaarCardDaoImpl();
			System.out.println("Enter emp id");
			Long empId=sc.nextLong();
			System.out.println("Enter Adhaar Card details : card number, Date createdOn, location");
			System.out.println(dao.assignEmpAdhaarCard
					(empId, new AdhaarCard(sc.next(),LocalDate.parse(sc.next()),sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
