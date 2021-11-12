package io.github.jairosousa.quarkussocial.domain.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Autor Jairo Nascimento
 * @Created 12/11/2021 - 10:48
 */
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

}
