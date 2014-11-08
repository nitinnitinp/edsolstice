package com.edsolstice.educationportal.dbmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "chat")
public class Chat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	String  uid;
	String sender;
	String receiver;
	List<Message> messages = new ArrayList<Message>();
	

}
