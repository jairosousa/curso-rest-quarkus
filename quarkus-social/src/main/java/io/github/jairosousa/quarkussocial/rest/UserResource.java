package io.github.jairosousa.quarkussocial.rest;

import io.github.jairosousa.quarkussocial.rest.dto.CreateUserRequest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @Autor Jairo Nascimento
 * @Created 12/11/2021 - 09:17
 */
@Path("/users")
public class UserResource {

    @POST
    public Response createUser(CreateUserRequest userRequest) {
        return Response.ok().build();
    }
}
