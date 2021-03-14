package com.LTI.Helpdesk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.LTI.Helpdesk.entity.Department;

public interface DeptRepository extends MongoRepository<Department, String> {

}
