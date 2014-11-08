package com.edsolstice.educationportal.rest.restmodel;

import com.edsolstice.educationportal.dbmodel.Message;

public class ChatRESTV1 {

	String uid;
	String name;
	String time;
	String message;
	Message apiObject;

	public ChatRESTV1 (String uid , Message apiObject) {
		this.apiObject=apiObject;
		this.uid=uid;
	}

	public String getName() {
		return apiObject.getName();
	}


	public String getTime() {
		return apiObject.getMsgTime();
	}

	public String getMessage() {
		return apiObject.getMessage();
	}

	public String getUid() {
		return uid;
	}

}
