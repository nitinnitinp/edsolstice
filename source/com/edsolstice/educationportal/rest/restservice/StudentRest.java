
package com.edsolstice.educationportal.rest.restservice;

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
import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.rest.logic.StudentRestLogic;
import com.edsolstice.educationportal.rest.restmodel.StudentRESTV1;
import com.edsolstice.educationportal.utility.Constants;





/**
 * RESTful operations implementation for users.
 */

@Path ("/studentservice")
@RegisterService("userservice")
public class StudentRest {

	public StudentRest()  {
	}

	
	@Path ("/students/{uid}")
	@GET
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public StudentRESTV1 getUser (@Context HttpHeaders requestHeaders,	
			@HeaderParam(Constants.AUTH_HEADER) String sessionToken,
			@PathParam ("uid") String uid,
			@Context UriInfo uriInfo) throws Exception  {
	
		SessionService.isUserValid(sessionToken);
		
		StudentRestLogic student = new StudentRestLogic();
		
		 return student.getUser(uid);
		
		


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
	
	
	@Path ("/students/{uid}/accept/{id}")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public void acceptStudentRequest (@Context HttpHeaders requestHeaders,	
			@HeaderParam(Constants.AUTH_HEADER) String sessionToken,
			@PathParam ("uid") String uid,@PathParam ("id") String id,
			@Context UriInfo uriInfo) throws Exception  {
	
		SessionService.isUserValid(sessionToken);
		
		StudentRestLogic student = new StudentRestLogic();
		
		student.acceptStudentRequest(uid, id);
		
		
	}


}
