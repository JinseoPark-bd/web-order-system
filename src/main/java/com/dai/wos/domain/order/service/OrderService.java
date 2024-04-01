package com.dai.wos.domain.order.service;

import com.dai.wos.domain.order.entity.Order;
import com.dai.wos.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order save (Order order) {
        return orderRepository.save(order);
    }

}
