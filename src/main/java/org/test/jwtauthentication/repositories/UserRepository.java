package org.test.jwtauthentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.jwtauthentication.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
