package com.CrudApp.service;


import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CrudApp.model.Employee;
import com.CrudApp.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	private EmployeeRepository emprepo;
	
	@Override
	public List<Employee> getAllEmp() 
	{
		
		return emprepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		emprepo.save(employee);
		
	}

	@Override
	public Employee getEmpById(long id) {
		Optional<Employee> optional=emprepo.findById(id);
		Employee employee=null;
		if(optional.isPresent())
		{
			employee=optional.get();
		}
		else
		{
			throw new RuntimeException("Employee not founf for the ::"+id);
		}
		return employee;
		
	}

	@Override
	public void deleteEmployee(long id) {
		this.emprepo.deleteById(id);
		
	}

	

}
