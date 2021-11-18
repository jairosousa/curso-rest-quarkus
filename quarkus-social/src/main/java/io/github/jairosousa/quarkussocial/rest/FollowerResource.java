package io.github.jairosousa.quarkussocial.rest;

import io.github.jairosousa.quarkussocial.domain.model.Follower;
import io.github.jairosousa.quarkussocial.domain.repository.FollowerRepository;
import io.github.jairosousa.quarkussocial.domain.repository.UserRepository;
import io.github.jairosousa.quarkussocial.rest.dto.FollowerRequest;
import io.github.jairosousa.quarkussocial.rest.dto.FollowerResponse;
import io.github.jairosousa.quarkussocial.rest.dto.FollowersPerUserResponse;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

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

    @GET
    public Response listFollowrs(@PathParam("userId") Long userId) {
        var user = userRepository.findById(userId);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        var list = followerRepository.findByUser(userId);
        FollowersPerUserResponse followers = new FollowersPerUserResponse();
        followers.setFollowersCount(list.size());

        var followerList = list.stream()
                .map(FollowerResponse::new)
                .collect(Collectors.toList());

        followers.setContent(followerList);

        return Response.ok(followers).build();
    }

    @DELETE
    @Transactional
    public Response unfollowUser(@PathParam("userId") Long userId, @QueryParam("followerId") Long followerId) {
        var user = userRepository.findById(userId);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        followerRepository.deleteByFollowerAnsUser(followerId, userId);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
