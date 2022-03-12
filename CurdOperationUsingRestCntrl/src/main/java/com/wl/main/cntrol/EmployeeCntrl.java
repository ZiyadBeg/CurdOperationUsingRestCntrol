package com.wl.main.cntrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wl.main.entities.Employee;
import com.wl.main.service.EmployeeService;

@RestController
public class EmployeeCntrl {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "getAllEmployeeDetails")
	public Iterable<Employee>  getAllEmployeeDetails() {
		return employeeService.getAllEmployeeDetails();
		
	}
	
	@PostMapping(value="addEmployee")
	public Employee addEmployee(@RequestBody  Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping(value = "getAllEmployeeById/{empid}")
	public Employee getAllEmployeeById(@PathVariable("empid") Integer empid) {
		return  employeeService.getAllEmployeeById(empid);
		
	}
	
	@GetMapping(value = "deleteEmployeeById/{empid}")
	public void deleteEmployeeById(@PathVariable("empid") Integer empid) {
		  employeeService.deleteEmployeeById(empid);
		
	}
	
	@PutMapping(value="updateEmployee/{empid}")
	public Employee updateEmployee(@PathVariable("empid") Integer empid,@RequestBody  Employee employee) {
		return employeeService.updateEmployee(empid,employee);
	}
	
	@PutMapping(value="updateEmployeeEmail/{empid}/{newEmail}")/*regular expressoin after emailid:.+ {newEmail:.+}*/
	public Employee updateEmployeeEmail(@PathVariable("empid") Integer empid,@PathVariable("newEmail:.+") String newEmail) {
		return employeeService.updateEmployeeEmail(empid,newEmail);
	}
	/*
	If you are using 	ziyad@yahoon.com as an email field it will tuncate this .com to usse delete naa kare iskaliye hum user karte hai
	regular expressoin after emailid:.+ {newEmail:.+}
	  */
	}
