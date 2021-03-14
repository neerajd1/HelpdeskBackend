package com.LTI.Helpdesk.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "department")
public class DeptInputModel {

	@Id
	@NotBlank
	private String deptName;

	private String deptDescription;

	@NotBlank
	private boolean islocked;
}
