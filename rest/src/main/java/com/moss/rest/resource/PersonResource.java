package com.moss.rest.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.moss.rest.model.Person;


/**
 * Root resource (exposed at "persons" path)
 */
@Path("persons")
public class PersonResource {

	private Map<Long, Person> storage = new HashMap<Long, Person>();

	public PersonResource() {
		storage.put(1L, new Person("Bolek", 1967));
		storage.put(2L, new Person("Lolek", 1968));
		storage.put(3L, new Person("Tola", 1969));
	}

    @GET
    @Path("/{personId}")
    @Produces("application/json")
	public Person getPerson(@PathParam("personId") Long id){
		Person p = storage.get(id);
		if (p == null) return new Person();
		return p;
	}
    
    @GET
	@Produces("text/html")
	public String getHome(){
		return "hehe";
	}
}
