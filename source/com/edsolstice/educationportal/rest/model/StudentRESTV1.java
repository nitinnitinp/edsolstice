package com.edsolstice.educationportal.rest.model;

import java.util.ArrayList;
import java.util.List;

import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;

public class StudentRESTV1  extends StudentBaseRESTV1{
	
	String email;
	String firstName;
	String lastName;
	String college;
	String stream;
	String fieldOfInterest;
	String gender;
	List<StudentBaseRESTV1> pendingRequests = new ArrayList<StudentBaseRESTV1> ();
	List<StudentBaseRESTV1> sentRequests = new ArrayList<StudentBaseRESTV1> ();
	List<StudentBaseRESTV1> registeredStudents=new ArrayList<StudentBaseRESTV1> ();

	public StudentRESTV1(Student student) {
		
		super(student);
		
	} 

	public String getFirstName() {
		return apiObject.getFirstName();
	}

	public String getLastName() {
		return apiObject.getLastName();
	}

	public String getCollege() {
		return apiObject.getCollege();
	}


	public String getStream() {
		return apiObject.getStream();
	}

	public String getFieldOfInterest() {
		return apiObject.getFieldOfInterest();
	}

	public String getGender() {
		return apiObject.getGender();
	}

	public List<StudentBaseRESTV1> getPendingRequests() {
        for(String uid : apiObject.getStudentRequestPending()) {
            Student student = DBFactory.getStudentDB().get("uid", uid);
            StudentBaseRESTV1 base = new StudentBaseRESTV1(student);
            pendingRequests.add(base);
        }
        
        return pendingRequests;
	}

	public List<StudentBaseRESTV1> getSentRequests() {
		
		for(String uid : apiObject.getStudentRequestSent()) {
            Student student = DBFactory.getStudentDB().get("uid", uid);
            StudentBaseRESTV1 base = new StudentBaseRESTV1(student);
            sentRequests.add(base);
        }
		return sentRequests;
	}

	public List<StudentBaseRESTV1> getRegisteredStudents() {
		for(String uid : apiObject.getRegisteredStudents()) {
            Student student = DBFactory.getStudentDB().get("uid", uid);
            StudentBaseRESTV1 base = new StudentBaseRESTV1(student);
            registeredStudents.add(base);
        }
		return registeredStudents;
	}



}
