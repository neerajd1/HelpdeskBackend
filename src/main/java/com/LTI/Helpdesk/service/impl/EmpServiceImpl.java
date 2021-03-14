package com.LTI.Helpdesk.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LTI.Helpdesk.entity.Employee;
import com.LTI.Helpdesk.exceptions.EmployeeException;
import com.LTI.Helpdesk.model.EmpInputModel;
import com.LTI.Helpdesk.repository.EmpRepository;
import com.LTI.Helpdesk.service.EmpService;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmpRepository empRepository;

	@Override
	public Employee saveEmployee(EmpInputModel employee) {

		Employee saveEmployee = new Employee();
		modelMapper.map(employee, saveEmployee);
		return empRepository.save(saveEmployee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	@Override
	public void deleteEmployee(String empID) {
		Employee employee = findEmployee(empID);
		empRepository.delete(employee);
	}

	@Override
	public Employee findEmployee(String empID) {
		return empRepository.findById(empID)
				.orElseThrow(() -> new EmployeeException("Employee " + empID + " Not Found"));
	}

	@Override
	public Employee modifyEmployee(String empID, Employee employee) {
		Employee empSave = findEmployee(empID);
		if (!employee.getEmpID().equals(empSave.getEmpID())) {
			throw new EmployeeException("Can't update Employee ID");
		} else if (!employee.getJoiningDate().toString().equals(empSave.getJoiningDate().toString())) {
			throw new EmployeeException("Can't update Joining date");
		} else if (!employee.getBusinessEmailId().equals(empSave.getBusinessEmailId())) {
			throw new EmployeeException("Can't update Business Email ID");
		} else {
			modelMapper.map(employee, empSave);
			return empRepository.save(empSave);
		}

	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		List<Employee> employeeList = empRepository.findByFirstName(firstName);
		if (employeeList.isEmpty()) {
			throw new EmployeeException("No records found");
		}
		return employeeList;
	}

	@Override
	public List<Employee> findByDeptName(String deptName) {
		List<Employee> employeeList = empRepository.findByDeptName(deptName);
		if (employeeList.isEmpty()) {
			throw new EmployeeException("No records found");
		}
		return employeeList;
	}

}
