package com.edsolstice.educationportal.rest.restservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.edsolstice.educationportal.app.RegisterService;
import com.edsolstice.educationportal.auth.SessionService;
import com.edsolstice.educationportal.dbmodel.DbMgr;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.logic.Constants;
import com.edsolstice.educationportal.rest.restoperation.LoginSessionOperation;
import com.edsolstice.educationportal.rest.restoperation.UserLoginOperation;
 
@Path("/sessionservice")
@RegisterService("sessionservice")
public class SessionRest {
	
	@Path ("/login")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public LoginSessionOperation login (@Context HttpHeaders requestHeaders,		
			@Context UriInfo uriInfo,UserLoginOperation loginUser) throws Exception  {
		
		if(loginUser == null || loginUser.getEmail() ==null || loginUser.getPassword()==null) {
			 Response.status(400);
			 throw new Exception("Bad request"); 
		}
		
		Student user=DbMgr.getInstance().getEDSUserByEmail(loginUser.getEmail());
		
		if(user == null) {
			throw new Exception("User not found"); 
		}
		
		if(!user.getPassword().equals(loginUser.getPassword())) {
			throw new Exception("password does not match"); 
		}
		
		if(!user.isActive()) {
			throw new Exception("Please activate your account using login to your email"); 
		}
		
		return user.mapSessionUser(SessionService.addUser(user.getEmail(), user.getPassword()));
 
}
	
	
	@Path ("/logout")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	public Response logout (@Context HttpHeaders requestHeaders,	
			@HeaderParam(Constants.AUTH_HEADER) String sessionToken,	
			@Context UriInfo uriInfo) throws Exception  {
		
		if(sessionToken==null) {
			 Response.status(400);
			 throw new Exception("invalid session"); 
		}
		
		SessionService.isUserValid(sessionToken);
		SessionService.removeUser(sessionToken);
		
		return null;
 
}
	
}
