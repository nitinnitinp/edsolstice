/*
 * (C) Copyright 2002-2014 Hewlett-Packard Development Company, L.P.
 */

package com.edsolstice.educationportal.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.edsolstice.educationportal.app.RegisterService;
import com.edsolstice.educationportal.model.EDSUserCreate;



/**
 * RESTful operations implementation for users.
 */

@Path ("/userservice")
@RegisterService("userservice")
public class EDSUserRest {

	public EDSUserRest()  {
	}

	@Path ("/users")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public Response createUsers(@Context HttpHeaders requestHeaders,
		EDSUserCreate user,
			@Context UriInfo uriInfo) throws Exception  {
		//EDSUserCreate createUser=user.convert(EDSUserCreate.class);
		//String response = "user : " +createUser.getUserName()+ " has created " ;
		System.out.println(user);
		return Response.status(200).entity(user).build();



	}

	
	@Path ("/users")
	@GET
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public EDSUserCreate getUser (@Context HttpHeaders requestHeaders,
			
			@Context UriInfo uriInfo) throws Exception  {
		//EDSUserCreate createUser=user.convert(EDSUserCreate.class);
		//String response = "user : " +createUser.getUserName()+ " has created " ;
		//System.out.println(user);
		
		EDSUserCreate user = new EDSUserCreate();
		user.setUserName("nitin");
		user.setPassword("password");
		return user;



	}


}
