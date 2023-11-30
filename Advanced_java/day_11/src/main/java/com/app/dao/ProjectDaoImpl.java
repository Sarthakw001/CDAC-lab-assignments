package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.pojos.Employee;
import com.app.pojos.Project;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public String assignEmpProject(Long empId, Project pro) {
		String mesg="assigning project failed : invalid emp id";
		
		Session session = getFactory().getCurrentSession();
	
		Transaction tx = session.beginTransaction();

		try {
			
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
			
				pro.addEmployee(emp);
				session.persist(pro);
				mesg="Assigned project to emp "+emp.getFirstName();
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
		
	}

}
