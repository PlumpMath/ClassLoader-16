package com.moss.rest.resource;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Root resource (exposed at "resources" path)
 */
@Path("resources")
public class Resources {

	@GET
    @Path("/message")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getMessageFile() {
	  File file = new File("classes/SomeClass.class");
      //System.out.println(file.getAbsolutePath());
      return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
          .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" )
          .build();
    }
	
	@GET
	@Produces("text/html")
	public String getHome(){
		return "hehe";
	}
}
