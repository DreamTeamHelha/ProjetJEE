package com.helha.service.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class BonjourService {

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String salut2()
	{
		return "Salut service web";
		
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String salut1()
	{
		return "Salut111111111111 service web";
		
	}
	
	@GET
	@Path("salut")
	public String salut()
	{
		return "Salut service web";
		
	}
	
	
	
}
