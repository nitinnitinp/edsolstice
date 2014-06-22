/*
 * (C) Copyright 2002-2014 Hewlett-Packard Development Company, L.P.
 */

package com.edsolstice.educationportal.rest;

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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.edsolstice.educationportal.app.RegisterService;
import com.edsolstice.educationportal.auth.SessionService;
import com.edsolstice.educationportal.dbmodel.EDSDbMgr;
import com.edsolstice.educationportal.dbmodel.EDSUser;
import com.edsolstice.educationportal.logic.Constants;
import com.edsolstice.educationportal.restmodel.EDSUserCreate;





/**
 * RESTful operations implementation for users.
 */

@Path ("/userservice")
@RegisterService("userservice")
public class EDSUserRest {

	public EDSUserRest()  {
	}

	@Path ("/users/{uid}")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public Response createSession(@Context HttpHeaders requestHeaders, EDSUserCreate user, 
			@Context UriInfo uriInfo) throws Exception  {
		return Response.status(200).entity(user).build();

	}

	
	@Path ("/users/{UID}")
	@GET
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public EDSUser getUser (@Context HttpHeaders requestHeaders,	
			@HeaderParam(Constants.AUTH_HEADER) String sessionToken,
			@PathParam ("UID") String UID,
			@Context UriInfo uriInfo) throws Exception  {
	
		SessionService.isUserValid(sessionToken);
		EDSUser user=EDSDbMgr.getInstance().getEDSUserByUID(UID);
		SessionService.isUserValid(user.getEmail(), sessionToken, user.getPassword());
		
		return user;



	}


}
