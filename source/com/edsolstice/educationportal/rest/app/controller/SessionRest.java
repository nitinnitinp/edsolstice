package com.edsolstice.educationportal.rest.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.edsolstice.educationportal.auth.SessionService;
import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.rest.model.SessionRESTV1;
import com.edsolstice.educationportal.rest.operation.UserLoginOperation;
import com.edsolstice.educationportal.utility.Constants;

@Controller
@RequestMapping("/sessionservice")
public class SessionRest {

	@RequestMapping (value = "/login" , method = RequestMethod.POST)
	public @ResponseBody SessionRESTV1 login (HttpServletRequest request,HttpServletResponse response,
			@RequestBody UserLoginOperation loginUser) throws Exception  {

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



		SessionRESTV1 session =new SessionRESTV1();
		session.setSessionToken(SessionService.addUser(user.getEmail(), user.getPassword()));

		session.setUid(user.getUid());
		return session;




	}


	@RequestMapping (value = "/logout" , method = RequestMethod.POST)
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public  void logout (HttpServletRequest request,HttpServletResponse response,
			@RequestHeader(Constants.AUTH_HEADER) String sessionToken) throws Exception  {

		if(sessionToken==null) {
			//Response.status(400);
			throw new Exception("invalid session"); 
		}

		SessionService.isUserValid(sessionToken);
		SessionService.removeUser(sessionToken);



	}

	
	
}
