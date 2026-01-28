package com.nursery.app.features.users.repository;

import com.nursery.app.features.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUserName(String userName);
}
