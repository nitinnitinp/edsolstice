package com.edsolstice.educationportal.rest.app.service;

import org.springframework.stereotype.Service;

import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;

@Service
public class SecurityService {


	public void activate(String activationCode) throws Exception {

		if(activationCode == null) throw new Exception("Please provide the activation code");

		Student user= DBFactory.getStudentDB().get("activateCode" , activationCode);

		if(user==null) 
			throw new Exception("Please enter valid activation code");
		user.setActive(true);

		DBFactory.getStudentDB().update(user);

	}

}
