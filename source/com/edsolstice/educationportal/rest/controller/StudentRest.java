
package com.edsolstice.educationportal.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edsolstice.educationportal.auth.SessionService;
import com.edsolstice.educationportal.rest.logic.StudentRestLogic;
import com.edsolstice.educationportal.rest.restmodel.StudentRESTV1;
import com.edsolstice.educationportal.utility.Constants;





/**
 * RESTful operations implementation for users.
 */
@Controller
@RequestMapping("/studentservice")
public class StudentRest {

	
	
	
	@RequestMapping (value = "/students/{uid}" , method = RequestMethod.GET)
	public @ResponseBody StudentRESTV1 getUser (HttpServletRequest request,HttpServletResponse response,	
			@RequestHeader(value=Constants.AUTH_HEADER) String sessionToken,
			@PathVariable ("uid") String uid) throws Exception  {
	
		SessionService.isUserValid(sessionToken);
		
		StudentRestLogic student = new StudentRestLogic();
		
		 return student.getUser(uid);
		
		


	}
	
	
	
	@RequestMapping (value = "/students/{uid}/subscribe/{id}" , method = RequestMethod.POST)
	public void subscribeStudent (HttpServletRequest request,HttpServletResponse response,	
			@RequestHeader(value=Constants.AUTH_HEADER) String sessionToken,
			@PathVariable ("uid") String uid,@PathVariable ("id") String id) throws Exception  {
	
		SessionService.isUserValid(sessionToken);
		
		StudentRestLogic student = new StudentRestLogic();
		
		student.subscribeStudent(uid, id);
		
		
	}
	
	
	
	@RequestMapping (value = "/students/{uid}/accept/{id}" , method = RequestMethod.POST)
	public void acceptStudentRequest (HttpServletRequest request,HttpServletResponse response,	
			@RequestHeader(value=Constants.AUTH_HEADER) String sessionToken,
			@PathVariable ("uid") String uid,@PathVariable ("id") String id) throws Exception  {
	
		SessionService.isUserValid(sessionToken);
		
		StudentRestLogic student = new StudentRestLogic();
		
		student.acceptStudentRequest(uid, id);
		
		
	}


}
