package com.dai.wos.domain.user.repository;

import com.dai.wos.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findById(String id);
    boolean existsById(String id);

}
