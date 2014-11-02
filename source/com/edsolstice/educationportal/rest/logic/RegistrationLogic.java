package com.edsolstice.educationportal.rest.logic;

import com.edsolstice.educationportal.auth.AuthorizedUserManager;
import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.exception.EDSExceptionErrorCode;
import com.edsolstice.educationportal.exception.EDSExceptionMessage;
import com.edsolstice.educationportal.exception.EDSOperationException;
import com.edsolstice.educationportal.logic.MailUtility;
import com.edsolstice.educationportal.logic.StringUtils;
import com.edsolstice.educationportal.logic.UidUtils;
import com.edsolstice.educationportal.rest.restoperation.StudentCreateOperation;

public class RegistrationLogic {
	
	
	public Student registerStudent(StudentCreateOperation createStudent) throws Exception {
		
		   if(StringUtils.nullOrEmpty(createStudent.getEmail())) throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.INVALIDEMAIL);
		   // Validate email ID
		   MailUtility.isValidEmailAddress(createStudent.getEmail());
		   
		    Student student=DBFactory.getStudentDB().get("email", createStudent.getEmail());
			
		   if(student != null) {
			   throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.STUDENTALREADYEXIST);	
			}
			
			if(StringUtils.nullOrEmpty(createStudent.getPassword())) throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.NULLPASSWORD);
		
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
			
			//add student in database
			DBFactory.getStudentDB().save(student);
			
			
			return student;
		}
		
	}


