package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Student;
import utils.hibernateUtils;

public class StudentDaoImpl implements StudentDao{
	private SessionFactory sf;
	
	public StudentDaoImpl() {
		sf = hibernateUtils.getFactory();
	}

	@Override
	public void addStudent(Student st) {
		try (Session s = sf.openSession()){
			Transaction tx = s.beginTransaction();
			s.persist(st);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> getAllStudentDetails() {
		List<Student> students = null;
		String jpql = "select s from Student s";
		try(Session s = sf.openSession()){
			Transaction tx = s.beginTransaction();
			students = s.createQuery(jpql, Student.class).getResultList();
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return students;
	}
}
