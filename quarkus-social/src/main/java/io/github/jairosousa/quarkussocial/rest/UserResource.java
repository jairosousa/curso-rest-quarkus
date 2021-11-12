package io.github.jairosousa.quarkussocial.rest;

import io.github.jairosousa.quarkussocial.dpmain.model.User;
import io.github.jairosousa.quarkussocial.rest.dto.CreateUserRequest;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.transaction.Transactional;
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
    @Transactional
    public Response createUser(CreateUserRequest userRequest) {
        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());

        user.persist();
        return Response.ok(user).build();
    }

    @GET
    public Response getAll() {
        PanacheQuery<User> query = User.findAll();
        return Response.ok(query.list()).build();
    }
}
