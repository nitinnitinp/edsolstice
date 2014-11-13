package com.edsolstice.educationportal.rest.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.edsolstice.educationportal.auth.SessionService;
import com.edsolstice.educationportal.rest.app.service.ChatService;
import com.edsolstice.educationportal.rest.model.ChatRESTV1;
import com.edsolstice.educationportal.rest.operation.ChatOperation;
import com.edsolstice.educationportal.rest.operation.SendMessageOperation;
import com.edsolstice.educationportal.utility.Constants;


@Controller
@RequestMapping("/chatservice")
public class ChatRest {

@Autowired    
ChatService chatService ;

	
	@RequestMapping (value = "/chat" , method = RequestMethod.POST)
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void sendMessage (HttpServletRequest request,HttpServletResponse response,	
			@RequestHeader(Constants.AUTH_HEADER) String sessionToken, SendMessageOperation chatOperation) throws Exception  {

		SessionService.isUserValid(sessionToken);

	
		chatService.sendMessage(chatOperation);
	}

	@RequestMapping (value = "/chat" , method = RequestMethod.GET)
	public @ResponseBody List<ChatRESTV1> getChatMessages (HttpServletRequest request,HttpServletResponse response,	
			@RequestHeader(Constants.AUTH_HEADER) String sessionToken, @RequestBody ChatOperation chatOperation) throws Exception  {

		SessionService.isUserValid(sessionToken);

	
		return chatService.getChatMessages(chatOperation);



	}
	
	
	
	@RequestMapping (value = "/chats" , method = RequestMethod.GET)
	public  @ResponseBody String getChatMessages (HttpServletRequest request,HttpServletResponse response) throws Exception  {

	    return chatService .getMes();
		
		



	}


	


}
