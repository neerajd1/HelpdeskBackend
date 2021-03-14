package com.LTI.Helpdesk.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LTI.Helpdesk.entity.Department;
import com.LTI.Helpdesk.entity.Employee;
import com.LTI.Helpdesk.exceptions.DepartmentException;
import com.LTI.Helpdesk.model.DeptInputModel;
import com.LTI.Helpdesk.repository.DeptRepository;
import com.LTI.Helpdesk.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DeptRepository deptRepository;

	@Override
	public Department saveDept(DeptInputModel department) {
		Department deptsave = new Department();
		modelMapper.map(department, deptsave);
		return deptRepository.save(deptsave);
	}

	@Override
	public List<Department> getAllDept() {
		return deptRepository.findAll();
	}

	@Override
	public void deleteDept(String deptName) {

		EmpServiceImpl empServiceImp = new EmpServiceImpl();
		List<Employee> empList = empServiceImp.findByDeptName(deptName);
		for (Employee emp : empList) {
			emp.setDeptName(" ");
		}
		deptRepository.delete(findDept(deptName));
	}

	@Override
	public Department findDept(String deptName) {
		return deptRepository.findById(deptName)
				.orElseThrow(() -> new DepartmentException("Department " + deptName + " Not Found"));
	}

	@Override
	public Department modifyDept(String deptName, DeptInputModel department) {
		Department deptsave = findDept(deptName);
		modelMapper.map(department, deptsave);
		return deptRepository.save(deptsave);
	}

}
