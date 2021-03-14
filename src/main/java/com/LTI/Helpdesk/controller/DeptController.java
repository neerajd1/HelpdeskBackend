package com.LTI.Helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LTI.Helpdesk.service.DeptService;

@RestController
@RequestMapping("/department")
public class DeptController {

	@Autowired
	@Qualifier("deptService")
	private DeptService deptService;

}
