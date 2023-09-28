package com.greatlearning.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empolyee {

	String employeeFirstName;
	String employeeLastName;
	@Id
	String employeeEmail;

	public Empolyee() {
	}

	public Empolyee(String employeeFirstName, String employeeLastName, String employeeEmail) {
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

}
