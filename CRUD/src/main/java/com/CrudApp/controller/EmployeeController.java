package com.CrudApp.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.CrudApp.model.Employee;
import com.CrudApp.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService empserv;
	
	
	@GetMapping("/home")
	public String viewHomepage(Model model) 
	{
		model.addAttribute("listEmployees", empserv.getAllEmp());
		return "index";
		
	}
	@GetMapping("/shownewempform")
	public String showNewEmpForm(Model model) 
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) 
	{
//		Save Emp to DataBase
		empserv.saveEmployee(employee);
		return "redirect:/home";
		
		
	}
	@GetMapping("/showformforupdate/{id}")
	public String showFormForUpdate(@PathVariable Long id,Model model)
	{
//		Get Emp form the Service
		Employee employee=empserv.getEmpById(id);
		model.addAttribute("employee", employee);
		
//		Set emp as a model attribute to pre populate the form
		return "update_emp";
		
	}
	
	@GetMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable long id)
	{
		this.empserv.deleteEmployee(id);
		return "redirect:/home";
	}

}
