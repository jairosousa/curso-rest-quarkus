package io.github.jairosousa.quarkussocial.domain.repository;

import io.github.jairosousa.quarkussocial.domain.model.Post;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * @Autor Jairo Nascimento
 * @Created 14/11/2021 - 12:51
 */
@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {
}
