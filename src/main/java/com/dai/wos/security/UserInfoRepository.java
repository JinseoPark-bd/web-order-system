package com.dai.wos.security;

import com.dai.wos.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<User, String> {
    Optional<User> findById(String username);
}
