package com.edsolstice.educationportal.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.rest.restoperation.UserActivationOperation;


@Controller
@RequestMapping("/accountactivatedservice")
public class AccountActivatedRest {
	
	
		public AccountActivatedRest()  {
		}

		@RequestMapping (value = "/activate" , method = RequestMethod.POST)
		public Student activate(HttpServletRequest request,HttpServletResponse response,  
				UserActivationOperation activate) throws Exception  {
		
			if(activate.getActivationCode() == null) throw new Exception("Please provide the activation code");
			Student user= DBFactory.getStudentDB().get("activateCode" , activate.getActivationCode());
			if(user==null)throw new Exception("Please enter valid activation code");
			user.setActive(true);
			DBFactory.getStudentDB().update(user);
			return user;

		}
}