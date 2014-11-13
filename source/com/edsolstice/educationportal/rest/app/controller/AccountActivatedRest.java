package com.edsolstice.educationportal.rest.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.rest.operation.UserActivationOperation;


@Controller
@RequestMapping("/accountactivatedservice")
public class AccountActivatedRest {
	
	
		public AccountActivatedRest()  {
		}

		@RequestMapping (value = "/activate" , method = RequestMethod.POST , consumes = "application/json", produces ="application/json")
		public @ResponseBody Student activate(HttpServletRequest request,HttpServletResponse response,  
		                                      @RequestBody UserActivationOperation activate) throws Exception  {
		
			if(activate.getActivationCode() == null) throw new Exception("Please provide the activation code");
			Student user= DBFactory.getStudentDB().get("activateCode" , activate.getActivationCode());
			if(user==null)throw new Exception("Please enter valid activation code");
			user.setActive(true);
			DBFactory.getStudentDB().update(user);
			return user;

		}
}
