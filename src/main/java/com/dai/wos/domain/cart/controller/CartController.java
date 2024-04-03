package com.dai.wos.domain.cart.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    // 장바구니 담기
    @PostMapping("/api/cart")
    public Response createCart() {

    }

    // 장바구니 조회
    @GetMapping("/api/cart")
    public Response findall() {

    }


    // 장바구니 아이템 삭제
    @DeleteMapping("/api/cart/{cartItemId}")
    // 장바구니 주문
}
