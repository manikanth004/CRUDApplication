package com.CrudApp.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.CrudApp.model.Employee;


public interface EmployeeService 
{
	List<Employee> getAllEmp();
	void saveEmployee(Employee employee);
	Employee getEmpById(long id);
	void deleteEmployee(long id);
	}
