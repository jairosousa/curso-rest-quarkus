package io.github.jairosousa.quarkussocial.rest;

import io.github.jairosousa.quarkussocial.rest.dto.CreateUserRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @Autor Jairo Nascimento
 * @Created 12/11/2021 - 09:17
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    public Response createUser(CreateUserRequest userRequest) {
        return Response.ok(userRequest).build();
    }

    @GET
    public Response getAll() {
        return Response.ok().build();
    }
}
