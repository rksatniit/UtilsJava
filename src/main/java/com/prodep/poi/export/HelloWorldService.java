package com.prodep.poi.export;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 

		String output = "Adam Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
 
}
