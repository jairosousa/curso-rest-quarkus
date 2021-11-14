package io.github.jairosousa.quarkussocial.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Autor Jairo Nascimento
 * @Created 14/11/2021 - 12:41
 */
@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_text")
    private String text;

    @Column(name = "dateTime")
    private LocalDateTime dataTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
