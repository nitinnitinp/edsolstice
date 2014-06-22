package com.edsolstice.educationportal.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
import com.edsolstice.educationportal.restmodel.EDSLoginUser;
import com.edsolstice.educationportal.restmodel.EDSSession;
import com.edsolstice.educationportal.restmodel.EDSUserCreate;
 
@Path("/loginsessionservice")
@RegisterService("loginsessionservice")
public class LoginSessionRest {
	
	@Path ("/login")
	@POST
	@Consumes (MediaType.APPLICATION_JSON )
	@Produces (MediaType.APPLICATION_JSON )
	public EDSSession getUser (@Context HttpHeaders requestHeaders,	
			@HeaderParam(Constants.AUTH_HEADER) String sessionToken,	
			@Context UriInfo uriInfo,EDSLoginUser loginUser) throws Exception  {
		
		if(loginUser == null || loginUser.getEmail() ==null || loginUser.getPassword()==null) {
			 Response.status(400);
			 throw new Exception("Bad request"); 
		}
		
		EDSUser user=EDSDbMgr.getInstance().getEDSUser(loginUser.getEmail());
		
		if(user == null) {
			throw new Exception("User not found"); 
		}
		
		if(!user.getPassword().equals(loginUser.getPassword())) {
			throw new Exception("password does not match"); 
		}
		
		return user.mapSessionUser(SessionService.addUser(user.getEmail(), user.getPassword()));
 
}
	
}
