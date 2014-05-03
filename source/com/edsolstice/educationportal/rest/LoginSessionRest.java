package com.edsolstice.educationportal.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.edsolstice.educationportal.app.RegisterService;
 
@Path("/loginsessionservice")
@RegisterService("loginsessionservice")
public class LoginSessionRest {
	
	@GET
	@Path("/{pathParameter}")
	public Response responseMsg( @PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

		String response = "Hello from: " + pathParameter + " : " + queryParameter;

		return Response.status(200).entity(response).build();
	}
 
}
