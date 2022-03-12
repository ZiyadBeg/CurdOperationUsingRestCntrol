package com.wl.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wl.main.entities.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>  {
}

