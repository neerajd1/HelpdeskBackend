package com.LTI.Helpdesk.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "department")
public class Department {

	@Id
	private String deptName;
	private String deptDescription;
	private boolean islocked;
}
