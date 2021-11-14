package io.github.jairosousa.quarkussocial.domain.repository;

import io.github.jairosousa.quarkussocial.domain.model.Follower;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * @Autor Jairo Nascimento
 * @Created 14/11/2021 - 13:34
 */
@ApplicationScoped
public class FollowerRepository implements PanacheRepository<Follower> {
}
