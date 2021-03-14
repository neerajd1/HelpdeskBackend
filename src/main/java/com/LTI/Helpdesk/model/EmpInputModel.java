package com.LTI.Helpdesk.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection = "employee")
public class EmpInputModel {

	@Id
	@NotBlank
	private String empID;
	@NotBlank
	private String firstName;
	@NotBlank
	private String middleName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String motherName;
	@NotBlank
	private char gender;
	private String contactNumber;
	@NotBlank
	private String city;
	@NotBlank
	private String businessEmailId;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@NotBlank
	private Date joiningDate;

	private String deptName;
	@NotBlank
	private String role;
	@NotBlank
	private boolean islocked;

}
