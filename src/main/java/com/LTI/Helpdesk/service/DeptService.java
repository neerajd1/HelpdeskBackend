package com.LTI.Helpdesk.service;

import java.util.List;

import com.LTI.Helpdesk.entity.Department;
import com.LTI.Helpdesk.model.DeptInputModel;

public interface DeptService {

	Department saveDept(DeptInputModel Department); // Create

	List<Department> getAllDept(); // Read all

	void deleteDept(String deptName);// Delete

	Department findDept(String deptName);// Read one

	Department modifyDept(String deptName, DeptInputModel Department);// Update

}
