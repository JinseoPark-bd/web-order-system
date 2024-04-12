package com.dai.wos.domain.cart.service;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.account.repository.AccountRepository;
import com.dai.wos.domain.account.service.AccountService;
import com.dai.wos.domain.cartItem.controller.dto.CartItemRequestDto;
import com.dai.wos.domain.cartItem.controller.dto.CartItemResponseDto;
import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.cartItem.entity.CartItem;
import com.dai.wos.domain.cart.repository.CartRepository;
import com.dai.wos.domain.cartItem.service.CartItemService;
import com.dai.wos.domain.item.controller.dto.ItemResponseDto;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.item.repository.ItemRepository;
import com.dai.wos.domain.item.service.ItemService;
import com.dai.wos.domain.order.service.OrderService;
import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartService {
    private final CartRepository cartRepository;
    private final ItemService itemService;
    private final CartItemService cartItemService;
    private final UserService userService;
    private final OrderService orderService;
    private final AccountService accountService;

    // 장바구니 담기
    @Transactional
    public void create(CartItemRequestDto req, String userId) throws Exception {
        ItemResponseDto item = itemService.findById(req.getItemId());
        User user = userService.findById(userId);

        if (item.getQuantity() < req.getQuantity()) {
            // 재고 부족 예외 처리
            throw new ChangeSetPersister.NotFoundException();
        }

        // 3. 장바구니가 없으면 장바구니 생성
        if (cartRepository.findByUser(user).isEmpty()) {
            // 장바구니가 없다면 생성
            Cart cart = new Cart(user);
            cartRepository.save(cart);
        }

        Cart cart = cartRepository.findByUser(user).get();

        cartItemService.save(req, cart);
    }

    // 장바구니 조회
    public List<CartItemResponseDto> findAll(User user) throws Exception{
        Cart cart = cartRepository.findByUser(user).orElseThrow(ChangeSetPersister.NotFoundException::new);

        List<CartItem> cartItems = cartItemService.findAllByCart(cart);
        List<CartItemResponseDto> result = new ArrayList<>();

        cartItems.stream().forEach(cartItem -> {
            result.add(new CartItemResponseDto().toDto(cartItem));
        });

        return result;
    }

    // 장바구니 품목 단건 삭제
    @Transactional
    public void deleteById(Long cartItemId, User user) throws Exception{
//        CartItem cartItem = cartItemService.
//        Cart cart = cartRepository.findById()
//        if (!cart.getUser().equals(user)) {
//            throw new ChangeSetPersister.NotFoundException();
//        }
        cartItemService.delete(cartItemId);
    }

    // 장바구니 비우기
    @Transactional
    public void reset (Long cartId) {
        cartItemService.deleteAll(cartId);
    }

    // 장바구니 주문하기 -> 재고확인 -> 재고부족 상품은 제외하고 실행
    @Transactional
    public void orderAll(User user, String actId) throws Exception {
        Cart cart = cartRepository.findByUser(user).orElseThrow(ChangeSetPersister.NotFoundException::new);
        Account account = accountService.findById(actId);
        orderService.create(cart, account);
    }

}