package com.edsolstice.educationportal.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edsolstice.educationportal.auth.SessionService;
import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.rest.restoperation.LoginSessionOperation;
import com.edsolstice.educationportal.rest.restoperation.UserLoginOperation;
import com.sun.mail.iap.Response;
 
@RequestMapping("/sessionservice")
public class SessionRest {
	
	@RequestMapping (value = "/login" , method = RequestMethod.POST)
	public LoginSessionOperation login (HttpServletRequest request,HttpServletResponse response,
			UserLoginOperation loginUser) throws Exception  {
		
		if(loginUser == null || loginUser.getEmail() ==null || loginUser.getPassword()==null) {
			// Response.status(400);
			 throw new Exception("Bad request"); 
		}
		
		Student user=DBFactory.getStudentDB().get("email" , loginUser.getEmail());
		
		if(user == null) {
			throw new Exception("User not found"); 
		}
		
		if(!user.getPassword().equals(loginUser.getPassword())) {
			throw new Exception("password does not match"); 
		}
		
		if(!user.isActive()) {
			throw new Exception("Please activate your account using login to your email"); 
		}
		
		return user.mapSessionUser(SessionService.addUser(user.getEmail(), user.getPassword()));
 
}
	
	
	@RequestMapping (value = "/logout" , method = RequestMethod.POST)
	public Response logout (HttpServletRequest request,HttpServletResponse response,
			@RequestHeader(value="sessionToken") String sessionToken) throws Exception  {
		
		if(sessionToken==null) {
			 //Response.status(400);
			 throw new Exception("invalid session"); 
		}
		
		SessionService.isUserValid(sessionToken);
		SessionService.removeUser(sessionToken);
		
		return null;
 
}
	
}