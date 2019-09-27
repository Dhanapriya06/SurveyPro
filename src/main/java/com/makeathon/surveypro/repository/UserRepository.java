package com.makeathon.surveypro.repository;


import com.makeathon.surveypro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByUserIdIn(List<Long> userIds);

    Optional<User> findByUserId(Long userId);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
