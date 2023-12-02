package dao;

import java.util.List;

import pojos.Student;

public interface StudentDao {
	public void addStudent(Student st);
	public List<Student> getAllStudentDetails ();
}
