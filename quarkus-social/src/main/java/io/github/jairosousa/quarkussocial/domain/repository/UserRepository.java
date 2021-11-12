package io.github.jairosousa.quarkussocial.domain.repository;

import io.github.jairosousa.quarkussocial.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * @Autor Jairo Nascimento
 * @Created 12/11/2021 - 16:58
 */
@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
