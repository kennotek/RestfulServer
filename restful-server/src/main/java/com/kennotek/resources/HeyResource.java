package com.kennotek.resources;

import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kennotek.IGetDate;

@Path("/Hey")
public class HeyResource {
	@Inject IGetDate first;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		return ("Hey - there");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/foo/{id}")
	public String foo(@PathParam("id")long id, @QueryParam("test") String test) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
		StringBuilder builder = new StringBuilder();

		builder.append("foo/"+id+": -> Hi there. You entered ").append(test).append("\n");
		builder.append(null == first? "first == null": "first != null").append("\n");
		builder.append("The first date is:").append(sdf.format(first.getDate())).append("\n");

		return builder.toString();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/foo/{id}/zoo/{fred}")
	public JsonTestClass fooZoo(@PathParam("id")long id, @PathParam("fred") String fred, @QueryParam("test") String test) {
		JsonTestClass a = new JsonTestClass();
		a.setId(id);
		a.setDate(first.getDate());
		a.setFred(fred);
		a.setTest(test);
		return a;
	}
}
