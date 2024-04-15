package com.dai.wos.domain.cartItem.repository;

import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.cartItem.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findAllByCart(Cart cart);

    @Query("select ci from OJT_OMS_CART_ITEM_JPA ci " +
            "where ci.cart.cartId = :cartId " +
            "and ci.item.itemId = :itemId")
    Optional<CartItem> findByCartIdAndItemId(@Param("cartId") Long cartId,@Param("itemId") String itemId);

    @Modifying
    @Query("delete from OJT_OMS_CART_ITEM_JPA ci where ci.cart.cartId = :cartId ")
    void deleteByCartId(@Param("cartId") Long cartId);
}

