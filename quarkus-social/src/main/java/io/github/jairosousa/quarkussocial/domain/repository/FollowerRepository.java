package io.github.jairosousa.quarkussocial.domain.repository;

import io.github.jairosousa.quarkussocial.domain.model.Follower;
import io.github.jairosousa.quarkussocial.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Autor Jairo Nascimento
 * @Created 14/11/2021 - 13:34
 */
@ApplicationScoped
public class FollowerRepository implements PanacheRepository<Follower> {
    public boolean follows(User follower, User user) {
        var params = Parameters
                .with("follower", follower)
                .and("user", user)
                .map();
        PanacheQuery<Follower> query = find("follower = :follower and user = :user ", params);
        Optional<Follower> result = query.firstResultOptional();

        return result.isPresent();
    }

    public List<Follower> findByUser(Long userId) {
        return find("user.id", userId).list();
    }

    public void deleteByFollowerAnsUser(Long followerId, Long userId) {
        var params = Parameters
                .with("followerId", followerId)
                .and("userId", userId)
                .map();
        delete("follower.id = :followerId and user.id = :userId ", params);;
    }
}
