package com.dai.wos.domain.cart.repository;

import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findAllByCart(Cart cart);
}
