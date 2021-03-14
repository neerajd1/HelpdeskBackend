package com.LTI.Helpdesk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LTI.Helpdesk.entity.Employee;
import com.LTI.Helpdesk.model.EmpInputModel;
import com.LTI.Helpdesk.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	@Qualifier("empService")
	private EmpService empService;

	@PostMapping("/save")
	public Employee saveEmployee(@Valid @RequestBody EmpInputModel emp) {
		return empService.saveEmployee(emp);
	}

	@GetMapping("/all")
	public List<Employee> getAllEmployee() {
		return empService.getAllEmployees();
	}

	@GetMapping("/get/empID")
	public Employee getEmployee(@RequestParam("empID") String empID) {
		return empService.findEmployee(empID);
	}

	@GetMapping("/get/deptName/employees")
	public List<Employee> getEmployeeByDept(@RequestParam("deptName") String deptName) {
		return empService.findByDeptName(deptName);
	}

	@DeleteMapping("/delete/{empID}")
	public void deleteEmployee(@PathVariable String empID) {
		empService.deleteEmployee(empID);
	}

	@PutMapping("/modify/{empID}")
	public Employee modifyStudentByFirstName(@PathVariable String empID, @RequestBody Employee employee) {
		return empService.modifyEmployee(empID, employee);
	}

}
