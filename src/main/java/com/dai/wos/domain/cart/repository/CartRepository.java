package com.dai.wos.domain.cart.repository;

import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
