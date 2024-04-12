package com.dai.wos.domain.order.service;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.cartItem.entity.CartItem;
import com.dai.wos.domain.cartItem.repository.CartItemRepository;
import com.dai.wos.domain.cartItem.service.CartItemService;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.order.controller.dto.OrderRequestDto;
import com.dai.wos.domain.order.controller.dto.OrderResponseDto;
import com.dai.wos.domain.order.entity.Order;
import com.dai.wos.domain.order.repository.OrderRepository;
import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartItemService cartItemService;
    private final UserService userService;

    public Order save (Order order) {
        return orderRepository.save(order);
    }

    public String create(Cart cart, Account account) {
        /**
         * 1. Cart 가져오기
         * 2. Cart에 있는 List<CartItem> 가져오기
         * 3. List에 있는 CartItem 하나 씩 주문 생성
         */
        List<CartItem> cartItems = cartItemService.findAllByCart(cart);
        for(CartItem cartItem : cartItems) {
            Item item = cartItem.getItem();
            if(cartItem.getQuantity() <= item.getQuantity()) {
                item.subQuantity(cartItem.getQuantity());
                Order order = Order.builder()
                        .account(account)
                        .item(item)
                        .owner(item.getOwner())
                        .quantity(cartItem.getQuantity())
                        .build();
                orderRepository.save(order);
            }
        }

        return "주문이 등록되었습니다.";
    }

    // 시작-종료 날짜 순 주문 리스트 -> 화주코드, 거래처, 날짜, 주문자
    public List<OrderResponseDto> findAll(OrderRequestDto req, String userId) {
        User user = userService.findById(userId);
        String ownerId = user.getOwner().getOwnerId();
        String actId = req.getActId();
        Date start = req.getStartDate();
        Date end = req.getEndDate();
        return orderRepository.findByDateBetweenDesc(userId, ownerId, actId, start, end).stream()
                .map(order -> OrderResponseDto.toDto(order))
                .collect(Collectors.toList());
    }
}
