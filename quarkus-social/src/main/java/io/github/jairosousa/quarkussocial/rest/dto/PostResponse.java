package io.github.jairosousa.quarkussocial.rest.dto;

import io.github.jairosousa.quarkussocial.domain.model.Post;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Autor Jairo Nascimento
 * @Created 14/11/2021 - 13:08
 */
@Data
public class PostResponse {

    private String text;
    private LocalDateTime dateTime;

    public static PostResponse fromEntity(Post post) {
        var response = new PostResponse();
        response.setText(post.getText());
        response.setDateTime(post.getDateTime());
        return response;
    }
}
