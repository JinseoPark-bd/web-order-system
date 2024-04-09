package com.dai.wos.domain.cartItem.controller.dto;

import com.dai.wos.domain.cartItem.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponseDto {
    private Long cartItemId;
    private String itemId;
    private String itemNm;
    private Integer quantity;

    public static CartItemResponseDto toDto(CartItem cartItem) {
        return new CartItemResponseDto(
                cartItem.getCartItemId(),
                cartItem.getItem().getItemId(),
                cartItem.getItem().getItemNm(),
                cartItem.getQuantity());
    }
}
