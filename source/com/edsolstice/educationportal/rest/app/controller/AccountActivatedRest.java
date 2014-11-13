package com.edsolstice.educationportal.rest.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.rest.app.service.SecurityService;
import com.edsolstice.educationportal.rest.operation.UserActivationOperation;


@Controller
@RequestMapping("/accountactivatedservice")
public class AccountActivatedRest {
	@Autowired
	SecurityService securityService;
		

		@RequestMapping (value = "/activate" , method = RequestMethod.POST , consumes = "application/json", produces ="application/json")
		@ResponseStatus (HttpStatus.NO_CONTENT)
		public void  activate(HttpServletRequest request,HttpServletResponse response,  
		                                      @RequestBody(required = true) UserActivationOperation activate) throws Exception  {
			
			securityService.activate(activate.getActivationCode());

		}
}
