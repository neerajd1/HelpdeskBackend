package com.LTI.Helpdesk.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection = "employee")
public class Employee {

	@Id
	private String empID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String motherName;

	private char gender;
	private String contactNumber;
	private String city;
	private String businessEmailId;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date joiningDate;

	private String deptName;
	private String role;
	private boolean islocked;

}
