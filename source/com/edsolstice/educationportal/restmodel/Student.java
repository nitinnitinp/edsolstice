package com.edsolstice.educationportal.restmodel;

import com.edsolstice.educationportal.dbmodel.EDSBaseObject;

public class Student extends EDSBaseObject	 {
String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
}
