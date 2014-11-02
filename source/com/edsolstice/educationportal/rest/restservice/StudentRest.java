
package com.edsolstice.educationportal.rest.restservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
	public Student getUser (@Context HttpHeaders requestHeaders,	
			@HeaderParam(Constants.AUTH_HEADER) String sessionToken,
			@PathParam ("uid") String uid,
			@Context UriInfo uriInfo) throws Exception  {
	
		SessionService.isUserValid(sessionToken);
		Student user=DBFactory.getStudentDB().get("uid",uid);
		SessionService.isUserValid(user.getEmail(), sessionToken, user.getPassword());
		
		return user;



	}


}
