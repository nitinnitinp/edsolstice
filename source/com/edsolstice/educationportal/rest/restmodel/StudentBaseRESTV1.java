package com.edsolstice.educationportal.rest.restmodel;

import com.edsolstice.educationportal.dbmodel.Student;

public class StudentBaseRESTV1 {

	String uid;
	String name;
	String uri;
	Student apiObject;

	public StudentBaseRESTV1(Student student) {
		this.apiObject=student;
	} 

	public String getUid() {
		return apiObject.getUid();
	}

	public String getUri() {
		return apiObject.getUid();
	}

	public String getName() {
		return apiObject.getFirstName() + " "+apiObject.getLastName();
	}


}
