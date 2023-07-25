package com.FullStackWebApplication.Backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FullStackWebApplication.Backend.model.StudentIP;
import com.FullStackWebApplication.Backend.model.StudentOP;
import com.FullStackWebApplication.Backend.repository.StudentRepository;

@Service
public class StudentService {
	private static final Logger log = LoggerFactory.getLogger(StudentService.class);
	@Autowired
	private StudentRepository repository;

	@Transactional
	public StudentOP addStudentDetails(StudentIP studentIP) {
		log.info("Inside add student details method of service class");
		String id = studentIP.getId();
		String name = studentIP.getName();
		String email = studentIP.getEmail();
		String year = studentIP.getYear();
		String contact = studentIP.getContact();
		StudentOP studentOP = new StudentOP();
		int idExists = repository.findRecordById(id);
		if (idExists > 0) {
			studentOP.setStatus("Student Id already exists");
		} else {
			int status = repository.addRecord(id, contact, email, name, year);
			String msg = "";
			if (status == 0) {
				msg = "Failure while adding records to database";
			} else
				msg = "Success";
			studentOP.setStatus(msg);
		}
		return studentOP;
	}

}
