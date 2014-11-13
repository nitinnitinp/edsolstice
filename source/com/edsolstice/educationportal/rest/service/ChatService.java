package com.edsolstice.educationportal.rest.service;

import java.util.ArrayList;
import java.util.List;

import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.db.DatabaseTransation;
import com.edsolstice.educationportal.dbmodel.Chat;
import com.edsolstice.educationportal.dbmodel.Message;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.rest.restmodel.ChatRESTV1;
import com.edsolstice.educationportal.rest.restoperation.ChatOperation;
import com.edsolstice.educationportal.rest.restoperation.SendMessageOperation;
import com.edsolstice.educationportal.utility.UidUtils;

public class ChatService {

	public void sendMessage(SendMessageOperation sendMessage) {

		if(sendMessage.getTime() == null) {
			/// throw exception 
		}

		if(sendMessage.getSender() == null) {
			/// throw exception 
		}

		if(sendMessage.getReceiver() == null) {
			/// throw exception 
		}

		String uid = UidUtils.getUid(sendMessage.getSender(), sendMessage.getReceiver());

		DatabaseTransation<Student> studentDto = DBFactory.getStudentDB();
		Student student = studentDto.get("uid" , sendMessage.getSender()) ;

		DatabaseTransation<Chat> dto=DBFactory.getChatDB();
		Chat chat = dto.get("uid", uid);

		Message message = new Message();
		message.setMessage(sendMessage.getMessage());
		message.setMsgTime(sendMessage.getTime());
		message.setName(student.getFirstName() + " "+student.getLastName());


		if(chat == null) {
			chat = new Chat();
			chat.setReceiver(sendMessage.getReceiver());
			chat.setSender(sendMessage.getSender());
			chat .setUid(uid);
		}

		chat.getMessages().add(message);

	}

	public List<ChatRESTV1> getChatMessages(ChatOperation chatOperation) {
		if(chatOperation.getSender() == null) {
			/// throw exception 
		}

		if(chatOperation.getReceiver() == null) {
			/// throw exception 
		}

		String uid = UidUtils.getUid(chatOperation.getSender(), chatOperation.getReceiver());

		DatabaseTransation<Chat> dto=DBFactory.getChatDB();
		Chat chat = dto.get("uid", uid);
		List<ChatRESTV1> msgs = new ArrayList<ChatRESTV1>();

		if(chat != null) {
			for(Message message : chat.getMessages() ) {

				ChatRESTV1 restV1 = new ChatRESTV1(chatOperation.getSender(), message);	
				msgs.add(restV1);
			}
		}
		return msgs ;

	}

}
