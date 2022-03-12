package com.wl.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wl.main.dao.EmployeeDao;
import com.wl.main.entities.Employee;

// If you want to change the service object with any specific name the after annotation ("write_name")
//@Service("EmployeeSrvc")

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}

	public Employee getAllEmployeeById(Integer empid) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeDao.findById(empid);
		return employee.get();
	}

	public void deleteEmployeeById(Integer empid) {
		employeeDao.deleteById(empid);
	}

	public Employee updateEmployee(Integer empid, Employee newemployee) {
		// TODO Auto-generated method stub
		/*Optional<Employee> employee = employeeDao.findById(empid);
		Employee emp = null;
		if (employee.isPresent()) {
			emp = employee.get();
			emp.setName(newemployee.getName());
			emp.setAddress(newemployee.getAddress());
			emp.setEmail(newemployee.getEmail());
			employeeDao.save(emp);
		}*/
		
			 return employeeDao.findById(empid).map(employee -> {
			      employee.setName(newemployee.getName());
		      employee.setAddress(newemployee.getAddress());
		      employee.setEmail(newemployee.getEmail());
		      return employeeDao.save(employee);
		    }).orElseGet(() -> {
		    	newemployee.setId(empid);
		      return employeeDao.save(newemployee);
		    });
		
	}

	public Iterable<Employee> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	public Employee updateEmployeeEmail(Integer empid, String newEmail) {
		// TODO Auto-generated method stub
		Employee newemployee=null;
		Optional<Employee> employee =employeeDao.findById(empid);
		if(employee.isPresent()) {
			newemployee=employee.get();
			newemployee.setEmail(newEmail);
			return employeeDao.save(newemployee);
		}
		
		
		return newemployee;
	}

}

