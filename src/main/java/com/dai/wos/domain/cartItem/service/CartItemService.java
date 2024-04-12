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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ItemService itemService;
    private final UserService userService;

    // 카트에 상품 추가
    public void create (CartItemRequestDto req, String userId) {
        ItemResponseDto itemResponseDto = itemService.findById(req.getItemId());
    }

    // 장바구니에 상품 추가
    public void save (CartItemRequestDto req, Cart cart) throws Exception{
        Item item = itemService.getById(req.getItemId());
        CartItem cartItem = CartItem.builder()
                        .cart(cart)
                        .item(item)
                        .quantity(req.getQuantity())
                        .build();
        cartItemRepository.save(cartItem);
    }

    // 장바구니 조회
    public List<CartItem> findAllByCart(Cart cart) {
        return cartItemRepository.findAllByCart(cart);
    }

    // 장바구니 단 건 삭제 cartItemId
    public void delete (Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    // 장바구니 비우기
    public void deleteAll (Long cartId) {
        cartItemRepository.deleteByCartId(cartId);
    }
}
