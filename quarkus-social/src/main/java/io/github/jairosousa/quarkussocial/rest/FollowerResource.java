package io.github.jairosousa.quarkussocial.rest;

import io.github.jairosousa.quarkussocial.domain.model.Post;
import io.github.jairosousa.quarkussocial.domain.model.User;
import io.github.jairosousa.quarkussocial.domain.repository.FollowerRepository;
import io.github.jairosousa.quarkussocial.domain.repository.PostRepository;
import io.github.jairosousa.quarkussocial.domain.repository.UserRepository;
import io.github.jairosousa.quarkussocial.rest.dto.CreatePostRequest;
import io.github.jairosousa.quarkussocial.rest.dto.PostResponse;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    
}
