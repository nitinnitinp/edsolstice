package com.edsolstice.educationportal.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edsolstice.educationportal.rest.logic.RegistrationRestLogic;
import com.edsolstice.educationportal.rest.restoperation.StudentCreateOperation;

/**
 * RESTful operations implementation for users.
 */

@RequestMapping ("/registrationservice")
public class RegistrationRest {
	
	public RegistrationRest()  {		
	}

	
	@RequestMapping (value = "/register" , method = RequestMethod.POST)
	public void createUser(HttpServletRequest request,HttpServletResponse response,
			StudentCreateOperation createStudent) throws Exception  {
		
		RegistrationRestLogic registration = new RegistrationRestLogic();
		registration.registerStudent(createStudent);
		
		 
	}
	
}
