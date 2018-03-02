package com.base.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.base.model.Example;
import com.base.service.EmployeeService;

@Controller
public class HelloWorldController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("message", "Hello Spring MVC!");

		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		LocalDate date = LocalDate.now();
		model.addAttribute("date", date.format(formatter));

		return "index";
	}
	
	@Autowired
	Example ex;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {

		// Java 8 LocalDate
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aspect.xml");
//		Example ex = ctx.getBean("example", Example.class);
		
		System.out.println("valor example: " + ex.getId());
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
		
		System.out.println(employeeService.getEmployee().getName());
		
		employeeService.getEmployee().setName("Juan");
		
//		employeeService.getEmployee().throwException();
		
		ctx.close();

		return "hello";
	}
}
