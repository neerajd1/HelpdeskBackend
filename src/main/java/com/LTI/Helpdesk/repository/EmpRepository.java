package com.LTI.Helpdesk.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.LTI.Helpdesk.entity.Employee;

//DAO
@Repository
public interface EmpRepository extends MongoRepository<Employee, String> {

	List<Employee> findByFirstName(String firstName);

	List<Employee> findByDeptName(String deptName);

}
