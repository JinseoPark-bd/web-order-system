package com.dai.wos.domain.cartItem.service;

import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.cart.service.CartService;
import com.dai.wos.domain.cartItem.controller.dto.CartItemRequestDto;
import com.dai.wos.domain.cartItem.entity.CartItem;
import com.dai.wos.domain.cartItem.repository.CartItemRepository;
import com.dai.wos.domain.item.controller.dto.ItemResponseDto;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.item.service.ItemService;
import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ItemService itemService;
    private final UserService userService;
    private final CartService cartService;

    // 카트에 상품 추가
    public void create (CartItemRequestDto req, String userId) {
        ItemResponseDto itemResponseDto = itemService.findById(req.getItemId());
    }

    // cartItem 생성
    public void save (CartItemRequestDto req, String userId, Cart cart) {
        User user = userService.findById(userId);
        Item item = itemService.findById(req.)
        CartItem cartItem = CartItem.builder()
                        .
        cartItemRepository.save()
    }

}
