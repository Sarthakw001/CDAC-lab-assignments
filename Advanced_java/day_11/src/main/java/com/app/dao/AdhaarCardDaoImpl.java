package com.app.dao;

import org.hibernate.*;
import static com.app.utils.HibernateUtils.getFactory;

import com.app.pojos.AdhaarCard;
import com.app.pojos.Employee;


public class AdhaarCardDaoImpl implements AdhaarCardDao{

	@Override
	public String assignEmpAdhaarCard(Long empId, AdhaarCard card) {
		
		String mesg = "Assign Adhaar Card to emp successfull!!..";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
				//card.setCardNumber(emp);
				session.persist(card);
				mesg="Assigned Adhaar Card to emp "+emp.getFirstName();
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
