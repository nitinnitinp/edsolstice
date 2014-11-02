package com.edsolstice.educationportal.db;

import com.edsolstice.educationportal.dbmodel.Student;

public class DBFactory {

	public static DatabaseTransation<Student> getStudentDB() {
		DatabaseTransation<Student> dto = new DatabaseTransation<Student>(Student.class);
		return dto;	
	}

}
