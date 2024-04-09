package com.dai.wos.domain.cart.controller;

import com.dai.wos.domain.cartItem.controller.dto.CartItemRequestDto;
import com.dai.wos.domain.cartItem.controller.dto.CartItemResponseDto;
import com.dai.wos.domain.cart.service.CartService;
import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final UserRepository userRepository;

    // 장바구니 담기
    @PostMapping("/api/cart")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody CartItemRequestDto req) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserNm(authentication.getName()).orElseThrow(ChangeSetPersister.NotFoundException::new);
        cartService.create(req, user);
        return "장바구니에 상품을 추가하였습니다.";
    }

    // 장바구니 조회
    @GetMapping("/api/cart")
    @ResponseStatus(HttpStatus.OK)
    public List<CartItemResponseDto> findAll() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserNm(authentication.getName()).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return cartService.findAll(user);
    }

    // 장바구니 품목 단건 삭제
    @DeleteMapping("/api/cart/{cartItemId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable("cartItemId") Long id) throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserNm(authentication.getName()).orElseThrow(ChangeSetPersister.NotFoundException::new);
        cartService.deleteById(id, user);
        return "상품을 삭제하였습니다.";
    }

    // 장바구니 물건 전체 구매
    @PostMapping("/api/cart/{actId}")
    @ResponseStatus(HttpStatus.OK)
    public String buyingAll(@PathVariable("actId") String actId) throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserNm(authentication.getName()).orElseThrow(ChangeSetPersister.NotFoundException::new);
        cartService.orderAll(user, actId);
        return "주문이 완료되었습니다.";
    }
}
