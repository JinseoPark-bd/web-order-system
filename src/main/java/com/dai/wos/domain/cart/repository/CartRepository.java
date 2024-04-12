package com.dai.wos.domain.cart.repository;

import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);

    @Query("SELECT c FROM OJT_OMS_CART_JPA c " +
            "WHERE c.user = :userId" )
    Optional<Cart> findByUserId(String userId);
}
