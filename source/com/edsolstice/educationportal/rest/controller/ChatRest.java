package com.edsolstice.educationportal.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edsolstice.educationportal.auth.SessionService;
import com.edsolstice.educationportal.rest.restmodel.ChatRESTV1;
import com.edsolstice.educationportal.rest.restoperation.ChatOperation;
import com.edsolstice.educationportal.rest.restoperation.SendMessageOperation;
import com.edsolstice.educationportal.rest.service.ChatService;
import com.edsolstice.educationportal.utility.Constants;


@Controller
@RequestMapping("/chatservice")
public class ChatRest {



	
	@RequestMapping (value = "/chat" , method = RequestMethod.POST)
	public void sendMessage (HttpServletRequest request,HttpServletResponse response,	
			@RequestHeader(value=Constants.AUTH_HEADER) String sessionToken, SendMessageOperation chatOperation) throws Exception  {

		SessionService.isUserValid(sessionToken);

		ChatService chatLogic = new ChatService();
		chatLogic.sendMessage(chatOperation);
	}

	@RequestMapping (value = "/chat" , method = RequestMethod.GET)
	public @ResponseBody List<ChatRESTV1> getChatMessages (HttpServletRequest request,HttpServletResponse response,	
			@RequestHeader(Constants.AUTH_HEADER) String sessionToken, @RequestBody ChatOperation chatOperation) throws Exception  {

		SessionService.isUserValid(sessionToken);

		ChatService chatLogic = new ChatService();
		return chatLogic.getChatMessages(chatOperation);



	}
	
	
	
	@RequestMapping (value = "/chats" , method = RequestMethod.GET)
	public  @ResponseBody String getChatMessages (HttpServletRequest request,HttpServletResponse response) throws Exception  {

		
		return "hello";



	}


	


}
