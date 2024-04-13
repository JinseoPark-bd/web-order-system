package com.dai.wos.domain.cart.controller;

import com.dai.wos.domain.cartItem.controller.dto.CartItemRequestDto;
import com.dai.wos.domain.cartItem.controller.dto.CartItemResponseDto;
import com.dai.wos.domain.cart.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    // 장바구니 담기
    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public String create(@Valid @RequestBody CartItemRequestDto req, @AuthenticationPrincipal User user) throws Exception{
        cartService.create(req, user.getUsername());
        return "장바구니에 상품을 추가하였습니다.";
    }

    // 장바구니 조회
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public List<CartItemResponseDto> findAll(@AuthenticationPrincipal User user) throws Exception {
        return cartService.findAll(user.getUsername());
    }

    // 장바구니 품목 단건 삭제
    @DeleteMapping("/{cartItemId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public String deleteById(@PathVariable("cartItemId") Long cartItemId, @AuthenticationPrincipal User user) throws Exception{
        cartService.deleteById(cartItemId, user.getUsername());
        return "상품을 삭제하였습니다.";
    }

    // 장바구니 물건 전체 구매
    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public String buyingAll(@PathVariable("actId") String actId, @AuthenticationPrincipal User user) throws Exception{
        String userId = user.getUsername();
        cartService.orderAll(actId, userId);
        return "주문이 완료되었습니다.";
    }
}
