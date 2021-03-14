package com.LTI.Helpdesk.service;

import java.util.List;

import com.LTI.Helpdesk.entity.Employee;
import com.LTI.Helpdesk.model.EmpInputModel;

public interface EmpService {

	Employee saveEmployee(EmpInputModel employee); // Create

	List<Employee> getAllEmployees(); // Read all

	void deleteEmployee(String empID);// Delete

	Employee findEmployee(String empID);// Read one

	Employee modifyEmployee(String empID, Employee employee);// Update

	List<Employee> findByFirstName(String firstName);

	List<Employee> findByDeptName(String deptName);

}
