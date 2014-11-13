package com.edsolstice.educationportal.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edsolstice.educationportal.rest.restoperation.StudentCreateOperation;
import com.edsolstice.educationportal.rest.service.RegistrationService;

/**
 * RESTful operations implementation for users.
 */
@Controller
@RequestMapping ("/registrationservice")
public class RegistrationRest {
	
	
	@RequestMapping (value = "/register" , method = RequestMethod.POST)
	public void createUser(HttpServletRequest request,HttpServletResponse response,
	                       @RequestBody StudentCreateOperation createStudent) throws Exception  {
		
		RegistrationService registration = new RegistrationService();
		registration.registerStudent(createStudent);
		
		 
	}
	
}
