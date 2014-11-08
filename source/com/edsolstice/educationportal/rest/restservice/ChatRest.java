package com.edsolstice.educationportal.rest.restservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.edsolstice.educationportal.app.RegisterService;
import com.edsolstice.educationportal.auth.SessionService;
import com.edsolstice.educationportal.rest.logic.ChatRestLogic;
import com.edsolstice.educationportal.rest.logic.StudentRestLogic;
import com.edsolstice.educationportal.rest.restmodel.ChatRESTV1;
import com.edsolstice.educationportal.rest.restmodel.StudentRESTV1;
import com.edsolstice.educationportal.rest.restoperation.ChatOperation;
import com.edsolstice.educationportal.utility.Constants;

@Path ("/studentservice")
@RegisterService("userservice")
public class ChatRest {


	public ChatRest()  {
	}


	@Path ("/chat")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public void sendMessage (@Context HttpHeaders requestHeaders,	
			@HeaderParam(Constants.AUTH_HEADER) String sessionToken,
			@Context UriInfo uriInfo, ChatOperation chatOperation) throws Exception  {

		SessionService.isUserValid(sessionToken);

		ChatRestLogic chatLogic = new ChatRestLogic();
		chatLogic.sendMessage(chatOperation);
	}

	@Path ("/chat")
	@GET
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public List<ChatRESTV1> getChatMessages (@Context HttpHeaders requestHeaders,	
			@HeaderParam(Constants.AUTH_HEADER) String sessionToken,
			@Context UriInfo uriInfo, ChatOperation chatOperation) throws Exception  {

		SessionService.isUserValid(sessionToken);

		ChatRestLogic chatLogic = new ChatRestLogic();
		return chatLogic.getChatMessages(chatOperation);






	}


	@Path ("/students/{uid}/subscribe/{id}")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public void subscribeStudent (@Context HttpHeaders requestHeaders,	
			@HeaderParam(Constants.AUTH_HEADER) String sessionToken,
			@PathParam ("uid") String uid,@PathParam ("id") String id,
			@Context UriInfo uriInfo) throws Exception  {

		SessionService.isUserValid(sessionToken);

		StudentRestLogic student = new StudentRestLogic();

		student.subscribeStudent(uid, id);


	}


}
