package com.greatlearning.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.entity.Empolyee;
import com.greatlearning.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepo;

	public void addEmployee(Empolyee addedEmployee) {

		emprepo.save(addedEmployee);

	}

	public void deleteEmployee(String employeeEmail) {

		emprepo.deleteById(employeeEmail);

	}

	public Empolyee getEmployee(String employeeEmail) {

		return emprepo.findById(employeeEmail).get();
	}

	public List<Empolyee> getAllEmployee() {

		return emprepo.findAll();
	}

	public void updateEmploye(String employeeEmail, Empolyee updatedEmployee) {

		Empolyee dbEmployee = getEmployee(employeeEmail);
		dbEmployee.setEmployeeFirstName(updatedEmployee.getEmployeeFirstName());
		dbEmployee.setEmployeeLastName(updatedEmployee.getEmployeeLastName());
		dbEmployee.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
		emprepo.save(dbEmployee);

	}

}
