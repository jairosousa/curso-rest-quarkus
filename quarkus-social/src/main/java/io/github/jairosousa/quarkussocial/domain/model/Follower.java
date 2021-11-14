package io.github.jairosousa.quarkussocial.domain.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Autor Jairo Nascimento
 * @Created 14/11/2021 - 13:30
 */
@Entity
@Table(name = "followers")
@Data
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;
}
