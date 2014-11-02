package com.edsolstice.educationportal.rest.restmodel;

import com.edsolstice.educationportal.dbmodel.Student;

public class StudentRESTV1 {
	String email;
	String firstName;
	String lastName;
	String college;
	String stream;
	String fieldOfInterest;
	String gender;
	
    Student apiObject;
	
	public StudentRESTV1(Student student) {
		this.apiObject=student;
	}   
	
	public String getEmail() {
		return apiObject.getEmail();
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

	
	

}
