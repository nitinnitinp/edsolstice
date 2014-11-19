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

      
        // get student 
		Student student = getRegisteredStudent(uid) ;
		
		// get subscribed student 
        Student subscribedStudent = getRegisteredStudent(subscribedId) ;
        
        // update request sent in the suscription
		
		student.getStudentSubscriptionSent().put(subscribedStudent.getUid(), subscribedStudent);
		
		
       
        subscribedStudent.getStudentSubscriptionPending().put(student.getUid(), student);
       

		//update student in database
		DBFactory.getStudentDB().update(student ,subscribedStudent);


		return student;
	}


	public Student acceptStudentRequest(String uid,  String acceptedId) throws Exception {


	    // get student 
        Student studentSubscribing= getRegisteredStudent(uid) ;
        
        // get subscribed student 
        Student studentsubscribed = getRegisteredStudent(acceptedId) ;
        
        // update request sent in the suscription
       
        studentSubscribing.getStudentSubscriptionSent().remove(studentsubscribed.getUid()); 
        studentSubscribing.getSubscribedStudent().put(studentsubscribed.getUid(), studentsubscribed);
        
        
        studentsubscribed.getStudentSubscriptionPending().remove(studentSubscribing.getUid());
        studentsubscribed.getSubscribedStudent().put(studentSubscribing.getUid(), studentSubscribing);
       
		//update student in database
        DBFactory.getStudentDB().update(studentSubscribing ,studentsubscribed);


		return studentSubscribing;
	}


	public StudentRESTV1 getStudent(String uid) throws EDSOperationException {
		
		Student student =getRegisteredStudent(uid);
		
		StudentRESTV1 response = new StudentRESTV1(student);
		
		return response;
	}
	
	
	
	private Student  getRegisteredStudent(String uid) throws EDSOperationException {
	    // get student 
        Student student = DBFactory.getStudentDB().get(uid);
        
        
        if(student == null) {
            throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.STUDENTDOESNOTEXIST + " "+uid);    
        }
        
        return student;
	}

}
