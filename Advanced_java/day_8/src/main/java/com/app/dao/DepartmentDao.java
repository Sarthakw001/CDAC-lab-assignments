package com.app.dao;

import com.app.pojos.Department;

public interface DepartmentDao {
	//method to create new dept
	String addNewDepartment(Department dept);

	//method to display dept details ONLY
	Department getDepartmentDetails(String deptName);

	//method to display dept details+emp details
	Department getDepartmentAndEmpDetails(String deptName);

	//method to display dept details+emp details , in a single join query
	Department getDepartmentAndEmpDetailsJoinFetch(String deptName);

	//method to delete dept details
	String deleteDeptDetails(String deptName);

}
