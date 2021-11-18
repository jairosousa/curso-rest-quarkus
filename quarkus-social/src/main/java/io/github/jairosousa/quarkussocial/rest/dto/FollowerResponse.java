package io.github.jairosousa.quarkussocial.rest.dto;

import io.github.jairosousa.quarkussocial.domain.model.Follower;
import lombok.Data;

/**
 * @Autor Jairo Nascimento
 * @Created 17/11/2021 - 11:08
 */
@Data
public class FollowerResponse {
    private Long id;
    private String name;

    public FollowerResponse() {
    }

    public FollowerResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public FollowerResponse(Follower follower) {
        this(follower.getFollower().getId(), follower.getFollower().getName());
    }
}
