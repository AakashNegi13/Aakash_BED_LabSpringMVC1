package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ems.entity.Empolyee;
import com.greatlearning.ems.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class ManagementController {

	@Autowired
	EmployeeService empser;

	@GetMapping("/getEmployee")
	public Empolyee getEmployee(@RequestParam("employeeEmail") String employeeEmail) {
		return empser.getEmployee(employeeEmail);

	}

	@GetMapping("/getAllEmployee")
	public List<Empolyee> getAllEmployee() {
		return empser.getAllEmployee();

	}

	@PostMapping("/addEmployeeReqparam")
	public String addEmployeeReqparam(@RequestParam("employeeFirstName") String employeeFirstName,
			@RequestParam("employeeLastName") String employeeLastName,
			@RequestParam("employeeEmail") String employeeEmail) {
		Empolyee addedEmployee = new Empolyee(employeeFirstName, employeeLastName, employeeEmail);
		empser.addEmployee(addedEmployee);
		return "Employee Added Successfully";

	}

	@PostMapping("/addEmployeeReqBody")
	public String addEmployeeReqBody(@RequestBody Empolyee addedEmployee) {
		empser.addEmployee(addedEmployee);
		return "Employee Added Successfully";

	}

	@PostMapping("/addEmployeePathVar/{employeeFirstName}/{employeeLastName}/{employeeEmail}")
	public String addEmployeePathVar(@PathVariable("employeeFirstName") String employeeFirstName,
			@PathVariable("employeeLastName") String employeeLastName,
			@PathVariable("employeeEmail") String employeeEmail)

	{
		Empolyee addedEmployee = new Empolyee(employeeFirstName, employeeLastName, employeeEmail);
		empser.addEmployee(addedEmployee);
		return "Employee Added Successfully";

	}

	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeEmail") String employeeEmail) {
		empser.deleteEmployee(employeeEmail);
		return "Employee Deleted Successfully";

	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("employeeEmail") String employeeEmail,
			@RequestBody Empolyee updatedEmploye) {
		empser.updateEmploye(employeeEmail, updatedEmploye);
		return "Employee Updated Successfully";
	}

	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		List<Empolyee> listEmpolyees = empser.getAllEmployee();
		theModel.addAttribute("empolyees", listEmpolyees);
		return "employees/list-employees";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Empolyee addedEmployee = new Empolyee();
		theModel.addAttribute("employee", addedEmployee);
		return "employees/employee-form";

	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Empolyee addedEmployee) {
		empser.addEmployee(addedEmployee);
		return "redirect:/employes/list";

	}

	@PostMapping("/delete")
	public String delEmp(@RequestParam("employeeEmail") String employeeEmail) {
		empser.deleteEmployee(employeeEmail);
		return "redirect:/employes/list";

	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeEmail") String employeeEmail, Model theModel) {
		Empolyee employeedb = empser.getEmployee(employeeEmail);
		theModel.addAttribute("employee", employeedb);
		return "employees/employee-form";
	}

}
