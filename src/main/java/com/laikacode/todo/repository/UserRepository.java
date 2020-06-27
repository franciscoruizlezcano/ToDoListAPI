package com.laikacode.todo.repository;

import com.laikacode.todo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * {@link User} repository extension of {@link JpaRepository}
 * @author Francisco
 * @since 2020/06/27
 * */

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

}
