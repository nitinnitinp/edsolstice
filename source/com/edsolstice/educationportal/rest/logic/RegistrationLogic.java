package com.edsolstice.educationportal.rest.logic;

import com.edsolstice.educationportal.auth.AuthorizedUserManager;
import com.edsolstice.educationportal.dbmodel.DbMgr;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.logic.MailUtility;
import com.edsolstice.educationportal.logic.StringUtils;
import com.edsolstice.educationportal.logic.UidUtils;
import com.edsolstice.educationportal.rest.restoperation.StudentCreateOperation;

public class RegistrationLogic {
	
	
	public Student registerStudent(StudentCreateOperation createStudent) throws Exception {
		
		   if(StringUtils.nullOrEmpty(createStudent.getEmail())) throw new Exception (" email id is null or not valid");
		   // Validate email ID
		   MailUtility.isValidEmailAddress(createStudent.getEmail());
		   
		   Student student=DbMgr.getInstance().getEDSUserByEmail(createStudent.getEmail());
			
		   if(student != null) {
				throw new Exception("User alredy exist") ;	
			}
			
			if(StringUtils.nullOrEmpty(createStudent.getPassword())) throw new Exception ("password is null");
		
		    student = new Student();
			student.setCollege(createStudent.getCollege());
			student.setEmail(createStudent.getEmail());
			student.setFieldOfInterest(createStudent.getFieldOfInterest());
			student.setFirstName(createStudent.getUserName());
			student.setGender(createStudent.getGender());
			student.setName(createStudent.getUserName());
			student.setMobile(createStudent.getMobile());
			student.setLastName(createStudent.getSurName());
			student.setPassword(createStudent.getPassword());
			student.setActive(false);
			student.setActivationCode(AuthorizedUserManager.getActivationToken());
			UidUtils.setUID(student);
			
			DbMgr.getInstance().addEDSUser(student);
			
			
			return student;
		}
		
	}


