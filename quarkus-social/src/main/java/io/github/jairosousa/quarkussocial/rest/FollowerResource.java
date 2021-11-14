package io.github.jairosousa.quarkussocial.rest;

import io.github.jairosousa.quarkussocial.domain.model.Follower;
import io.github.jairosousa.quarkussocial.domain.model.User;
import io.github.jairosousa.quarkussocial.domain.repository.FollowerRepository;
import io.github.jairosousa.quarkussocial.domain.repository.UserRepository;
import io.github.jairosousa.quarkussocial.rest.dto.FollowerRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @Autor Jairo Nascimento
 * @Created 14/11/2021 - 11:41
 */
@Path("/users/{userId}/followers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowerResource {

    private UserRepository userRepository;
    private FollowerRepository followerRepository;

    @Inject
    public FollowerResource(UserRepository userRepository, FollowerRepository followerRepository) {
        this.userRepository = userRepository;
        this.followerRepository = followerRepository;
    }

    @PUT
    public Response followerUser(@PathParam("userId") Long userId, FollowerRequest request) {
        var user = userRepository.findById(userId);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        var follower = userRepository.findById(request.getFollowerId());

        var entity = new Follower();
        entity.setUser(user);
        entity.setFollower(follower);

        followerRepository.persist(entity);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
