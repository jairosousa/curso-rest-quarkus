package io.github.jairosousa.quarkussocial.rest.dto;

import lombok.Data;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 17/11/2021 - 11:06
 */
@Data
public class FollowersPerUserResponse {
    private Integer followersCount;
    private List<FollowerResponse> content;
}
