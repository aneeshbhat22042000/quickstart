package com.example.demo;

import java.util.List;

import com.example.demo.entity.Fee;
import com.example.demo.entity.Student;
import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.services.FeeService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/v1/fees")
public class FeeResource {
	
	private FeeService service;
	
	public FeeResource() {
		super();
		this.service=new FeeService();
	}

	@GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Fee> findAll() {
        
        return this.service.findAll();
    }
	
	@GET
	@Path(value="/{key}")
    @Produces(value=MediaType.APPLICATION_JSON)
    public Fee findById(@PathParam("key")int key) {
        
        return this.service.findById(key)
        		.orElseThrow(()-> new WebApplicationException(
                        Response.ok(new ElementNotFoundException("Element Not Found","ERR-603"))
                        .build()));
    }
	
	@POST
    @Produces(value=MediaType.APPLICATION_JSON)
	@Consumes(value=MediaType.APPLICATION_JSON)
    public Response addFee(Fee entity) {
        
        return Response.status(201).entity(this.service.add(entity)).build();
    }
	@DELETE
	@Path(value="/{key}")
	public Response deleteById(@PathParam("key")int key) {
		int rowDeleted=this.service.removeById(key);
		if(rowDeleted==1) {
			return Response.status(200).entity("One Row Deleted").build();
		} else {
			throw new WebApplicationException(Response.
					ok(new ElementNotFoundException("ERR-603","Element Not Found")).build());
		}
	
	
	
	}
	
//	@PUT
//	public Response updateAmount(String branch,double revisedAmount){
//		return null;
//		
//	}
	
	
}
