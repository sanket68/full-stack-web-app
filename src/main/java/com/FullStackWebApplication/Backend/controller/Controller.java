package com.FullStackWebApplication.Backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FullStackWebApplication.Backend.model.StudentIP;
import com.FullStackWebApplication.Backend.model.StudentOP;
import com.FullStackWebApplication.Backend.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class Controller {
	private static final Logger log = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private StudentService service;

	@PostMapping("/add")
	public StudentOP addStudentDetails(@RequestBody StudentIP studentIP) throws Exception {
		log.info("Inside add student Details method of Controller");
		StudentOP studentOP = new StudentOP();
		if (isValidId(studentIP.getId()) && isValidContact(studentIP.getContact()))
			studentOP = service.addStudentDetails(studentIP);
		else
			studentOP.setStatus("Invalid Input Format");
		return studentOP;
	}

	public boolean isValidId(String id) {
		if (id == null) {
			return false;
		}
		int sz = id.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(id.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidContact(String contact) {
		if (contact == null || contact.length() != 10) {
			return false;
		}
		int sz = contact.length();

		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(contact.charAt(i)) == false) {
				return false;
			}
		}

		return true;
	}
}
