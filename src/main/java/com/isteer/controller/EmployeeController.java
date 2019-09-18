package com.isteer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="employee")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping(value="/employee")
	public ModelAndView addEmp(@ModelAttribute("employee") Employee employee)
	{
		try
		{
			if(employeeDao.getEmployeeById(employee.getId()) != null)
			{
				//employeeDao.updateEmployee(employee);
			}
		}
		catch(EmptyResultDataAccessException e)
		{
			System.out.println(e);
		}
		
		return new ModelAndView("redirect:/employees");
	}
}
