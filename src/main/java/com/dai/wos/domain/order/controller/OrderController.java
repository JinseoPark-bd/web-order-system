package com.dai.wos.domain.order.controller;

import com.dai.wos.domain.order.controller.dto.OrderRequestDto;
import com.dai.wos.domain.order.controller.dto.OrderResponseDto;
import com.dai.wos.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    // 주문 생성
    @PreAuthorize("isAuthenticated()")
    public String
    // 주문 조회
    @GetMapping("/list")
    @PreAuthorize("isAuthenticated()")
    public List<OrderResponseDto> searchOrder(@RequestBody OrderRequestDto req, @AuthenticationPrincipal User user) {
        return orderService.findAll(req, user.getUsername());
    }

}
