package com.edsolstice.educationportal.rest.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edsolstice.educationportal.rest.app.service.RegistrationService;
import com.edsolstice.educationportal.rest.operation.StudentCreateOperation;

/**
 * RESTful operations implementation for users.
 */
@Controller
@RequestMapping ("/registrationservice")
public class RegistrationRest {
    
    @Autowired
    RegistrationService registrationService;
	
	
	@RequestMapping (value = "/register" , method = RequestMethod.POST)
	public void createUser(HttpServletRequest request,HttpServletResponse response,
	                       @RequestBody StudentCreateOperation createStudent) throws Exception  {
		
		
	    registrationService.registerStudent(createStudent);
		
		 
	}
	
}
