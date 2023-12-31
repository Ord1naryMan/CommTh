package com.thingy.commth.db.repository;

import com.thingy.commth.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByUsernameIgnoreCase(String uName);


    User getUserById(long id);
}
