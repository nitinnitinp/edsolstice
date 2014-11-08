package com.edsolstice.educationportal.dbmodel;

import java.io.Serializable;


public class Message implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	String message;
    String status;
    String msgTime;
    String name;
    
    public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}
	

}
