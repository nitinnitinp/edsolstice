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

import com.edsolstice.educationportal.dbmodel.DbMgr;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.rest.restoperation.UserActivationOperation;

@Path ("/accountactivatedservice")
public class AccountActivatedRest {
	
	
		public AccountActivatedRest()  {
		}

		@Path ("/activate")
		@POST
		@Consumes (MediaType.APPLICATION_JSON )
		@Produces (MediaType.APPLICATION_JSON )
		public Response activate(@Context HttpHeaders requestHeaders,  
				UserActivationOperation activate, @Context UriInfo uriInfo) throws Exception  {
		
			if(activate.getActivationCode() == null) throw new Exception("Please provide the activation code");
			Student user= DbMgr.getInstance().getStudentByActivationCode(activate.getActivationCode());
			if(user==null)throw new Exception("Please enter valid activation code");
			user.setActive(true);
			DbMgr.getInstance().updateEDSUser(user);
			return Response.status(200).entity(user).build();

		}
}
