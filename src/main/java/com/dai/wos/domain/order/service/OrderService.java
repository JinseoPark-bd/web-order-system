package com.dai.wos.domain.order.service;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.cartItem.entity.CartItem;
import com.dai.wos.domain.cartItem.repository.CartItemRepository;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.order.entity.Order;
import com.dai.wos.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartItemRepository cartItemRepository;



    public Order save (Order order) {
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public String create(Cart cart, Account account) {
        /**
         * 1. Cart 가져오기
         * 2. Cart에 있는 List<CartItem> 가져오기
         * 3. List에 있는 CartItem 하나 씩 주문 생성
         */
        List<CartItem> cartItems = cartItemRepository.findAllByCart(cart);
        for(CartItem cartItem : cartItems) {
            Item item = cartItem.getItem();
            Order order = Order.builder()
                    .account(account)
                    .item(item)
                    .owner(item.getOwner())
                    .quantity(cartItem.getQuantity())
                    .build();
            orderRepository.save(order);
        }

        return "주문이 등록되었습니다.";
    }

    // 시작-종료 날짜 순 주문 리스트



}
