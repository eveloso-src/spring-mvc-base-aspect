package com.base.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	@RequestMapping(value = { "/loginRedirect" }, method = RequestMethod.GET)
	public String login(Model model) {

		// Java 8 LocalDate

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aspect.xml");
		// Example ex = ctx.getBean("example", Example.class);

		System.out.println("valor example: " + ex.getId());
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

		System.out.println(employeeService.getEmployee().getName());

		employeeService.getEmployee().setName("Juan");

		// employeeService.getEmployee().throwException();

		ctx.close();

		return "hello";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to mysite. ");
		// Get authenticated user name from SecurityContext
		SecurityContext context = SecurityContextHolder.getContext();

		model.addAttribute("message", "You are logged in as " + context.getAuthentication().getName());
		return "index";

		// return "welcome";
	}

	// @RequestMapping(value = "/admin", method = RequestMethod.GET)
	// public String adminPage(ModelMap model) {
	// model.addAttribute("user", getPrincipal());
	// return "admin";
	// }
	//
	// @RequestMapping(value = "/db", method = RequestMethod.GET)
	// public String dbaPage(ModelMap model) {
	// model.addAttribute("user", getPrincipal());
	// return "dba";
	// }
	//
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "welcome";
	}

//	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
//	public String accessDeniedPage(ModelMap model) {
//		model.addAttribute("user", getPrincipal());
//		return "accessDenied";
//	}

	// private String getPrincipal(){
	// String userName = null;
	// System.out.println("authentication: " +
	// SecurityContextHolder.getContext().getAuthentication());
	//
	// Object principal =
	// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	//
	// if (principal instanceof UserDetails) {
	// userName = ((UserDetails)principal).getUsername();
	// } else {
	// userName = principal.toString();
	// }
	// return userName;
	// }
}
