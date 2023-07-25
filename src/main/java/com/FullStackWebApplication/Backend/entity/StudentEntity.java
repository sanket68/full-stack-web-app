package com.FullStackWebApplication.Backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_table")
public class StudentEntity {
	@Id
	private String id;
	private String name;
	private String email;
	private String year;
	private String contact;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contactNumber) {
		this.contact = contactNumber;
	}

}
