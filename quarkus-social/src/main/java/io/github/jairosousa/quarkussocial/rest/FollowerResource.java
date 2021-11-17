package io.github.jairosousa.quarkussocial.rest;

import io.github.jairosousa.quarkussocial.domain.model.Follower;
import io.github.jairosousa.quarkussocial.domain.repository.FollowerRepository;
import io.github.jairosousa.quarkussocial.domain.repository.UserRepository;
import io.github.jairosousa.quarkussocial.rest.dto.FollowerRequest;

import javax.inject.Inject;
import javax.transaction.Transactional;
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

    @Transactional
    @PUT
    public Response followerUser(@PathParam("userId") Long userId, FollowerRequest request) {
        var user = userRepository.findById(userId);
        if (userId.equals(request.getFollowerId())) {
            return Response.status(Response.Status.CONFLICT).entity("You can't follow yourself").build();
        }

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        var follower = userRepository.findById(request.getFollowerId());

        boolean follows = followerRepository.follows(follower, user);

        if (!follows) {
            var entity = new Follower();
            entity.setUser(user);
            entity.setFollower(follower);

            followerRepository.persist(entity);
            return Response.status(Response.Status.NO_CONTENT).build();
        }

        return Response.status(Response.Status.CONFLICT).entity(follower.getName() + " voçê ja segue o " + user.getName()).build();
    }
}
