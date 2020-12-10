package com.github.juliherms.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.juliherms.model.User;

@Path("/users")
public class UserResource {

	List<User> users = new ArrayList<User>();

	private void initUsers() {

		User u = new User();

		u.id = 1L;
		u.name = "Juliherms";
		users.add(u);

		u = new User();
		u.id = 2L;
		u.name = "Fred";
		users.add(u);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> list() {

		initUsers();
		return users;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(User user) {

		this.users.add(user);
		return Response.status(Status.CREATED).build();

	}

}
