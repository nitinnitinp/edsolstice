package com.edsolstice.educationportal.rest;

import com.edsolstice.educationportal.app.RegisterService;
import com.edsolstice.educationportal.dbmodel.EDSDbMgr;
import com.edsolstice.educationportal.dbmodel.EDSUser;
import com.edsolstice.educationportal.restmodel.EDSUserCreate;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * RESTful operations implementation for users.
 */

@Path ("/registrationservice")
@RegisterService("userservice")
public class RegistrationRest {
	
	public RegistrationRest()  {		
	}

	@Path ("/users")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public Response createUser(@Context HttpHeaders requestHeaders,
		EDSUserCreate user,
			@Context UriInfo uriInfo) throws Exception  {
		
		EDSUser edsUser =user.covert();
		EDSDbMgr.getInstance().addEDSUser(edsUser);
		return Response.status(200).entity(edsUser).build();



	}


}
