package com.dai.wos.domain.user.repository;

import com.dai.wos.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
