package com.edsolstice.educationportal.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.edsolstice.educationportal.dbmodel.EDSDbMgr;
import com.edsolstice.educationportal.dbmodel.EDSUser;

@Path ("/accountactivatedservice")
public class AccountActivatedRest {
	
	
		public AccountActivatedRest()  {
		}

		@Path ("/users/{UID}")
		@POST
		@Consumes (MediaType.APPLICATION_JSON )
		@Produces (MediaType.APPLICATION_JSON )
		public Response activate(@Context HttpHeaders requestHeaders, @PathParam ("UID") String UID, 
				@Context UriInfo uriInfo) throws Exception  {
			
			EDSUser user= EDSDbMgr.getInstance().getEDSUserByUID(UID);
			user.setActive(true);
			EDSDbMgr.getInstance().updateEDSUser(user);
			
			return Response.status(200).entity(user).build();

		}
}
