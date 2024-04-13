package com.dai.wos.domain.cartItem.service;

import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.cartItem.controller.dto.CartItemRequestDto;
import com.dai.wos.domain.cartItem.entity.CartItem;
import com.dai.wos.domain.cartItem.repository.CartItemRepository;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ItemService itemService;

    // 이미 존재하는 상품인지 확인
    public boolean checkCartItem (Long cartId, String itemId) {
        return cartItemRepository.findByCartIdAndItemId(cartId, itemId).isPresent();
    }

    // 장바구니에 상품 추가
    public void save (CartItemRequestDto req, Cart cart) throws Exception{
        Item item = itemService.getById(req.getItemId());
        if(checkCartItem(cart.getCartId(), item.getItemId())) {

        }
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
