package com.edsolstice.educationportal.rest.app.service;

import org.springframework.stereotype.Service;

import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.exception.EDSExceptionErrorCode;
import com.edsolstice.educationportal.exception.EDSExceptionMessage;
import com.edsolstice.educationportal.exception.EDSOperationException;
import com.edsolstice.educationportal.rest.model.StudentRESTV1;

@Service
public class StudentService {


	public Student subscribeStudent(String uid,  String subscribedId) throws Exception {



		Student student=DBFactory.getStudentDB().get("uid" , uid);
		Student subscribedStudent=DBFactory.getStudentDB().get("uid" , subscribedId);

		if(student == null) {
			throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.STUDENTDOESNOTEXIST + " "+uid);	
		}

		if(subscribedStudent == null) {
			throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.STUDENTDOESNOTEXIST+ " "+subscribedId);	
		}

		subscribedStudent.getStudentRequestPending().add(uid);

		student.getStudentRequestSent().add(subscribedId);
		//add student in database
		DBFactory.getStudentDB().update(student);


		return student;
	}


	public Student acceptStudentRequest(String uid,  String acceptedId) throws Exception {



		Student student=DBFactory.getStudentDB().get("uid" , uid);
		Student addedStudent=DBFactory.getStudentDB().get("uid" , acceptedId);

		if(student == null) {
			throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.STUDENTDOESNOTEXIST + " "+uid);	
		}

		if(addedStudent == null) {
			throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.STUDENTDOESNOTEXIST+ " "+acceptedId);	
		}

		student.getStudentRequestPending().remove(acceptedId);

		student.getRegisteredStudents().add(acceptedId);

		addedStudent.getStudentRequestSent().remove(uid);

		addedStudent.getRegisteredStudents().add(uid);
		//add student in database
		DBFactory.getStudentDB().update(student);

		DBFactory.getStudentDB().update(addedStudent);


		return student;
	}


	public StudentRESTV1 getUser(String uid) {
		
		Student student =DBFactory.getStudentDB().get("uid",uid);
		
		StudentRESTV1 response = new StudentRESTV1(student);
		
		return response;
	}

}
