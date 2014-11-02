package com.edsolstice.educationportal.rest.restservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.edsolstice.educationportal.app.RegisterService;
import com.edsolstice.educationportal.rest.logic.RegistrationLogic;
import com.edsolstice.educationportal.rest.restoperation.StudentCreateOperation;

/**
 * RESTful operations implementation for users.
 */

@Path ("/registrationservice")
@RegisterService("userservice")
public class RegistrationRest {
	
	public RegistrationRest()  {		
	}

	@Path ("/register")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public Response createUser(@Context HttpHeaders requestHeaders,
			StudentCreateOperation createStudent,
			@Context UriInfo uriInfo) throws Exception  {
		
		RegistrationLogic registration = new RegistrationLogic();
		registration.registerStudent(createStudent);
		
		return Response.status(200).build();
	}
	
}
