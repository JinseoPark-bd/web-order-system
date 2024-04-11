package com.dai.wos.domain.cart.service;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.account.repository.AccountRepository;
import com.dai.wos.domain.cartItem.controller.dto.CartItemRequestDto;
import com.dai.wos.domain.cartItem.controller.dto.CartItemResponseDto;
import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.cartItem.entity.CartItem;
import com.dai.wos.domain.cartItem.repository.CartItemRepository;
import com.dai.wos.domain.cart.repository.CartRepository;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.item.repository.ItemRepository;
import com.dai.wos.domain.order.service.OrderService;
import com.dai.wos.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final OrderService orderService;
    private final AccountRepository accountRepository;

    // 장바구니 담기
    @Transactional
    public void create(CartItemRequestDto req, User user) throws Exception {
        Item item = itemRepository.findById(req.getItemId()).orElseThrow(ChangeSetPersister.NotFoundException::new);

        if (item.getQuantity() < req.getQuantity()) {
            //throw new LakingOfProductQuantity();
        }

        // 3. 장바구니 만들어줘야한다 사용자한테

        if (cartRepository.findByUser(user).isEmpty()) {
            // 장바구니가 없다면 생성
            Cart cart = new Cart(user);
            cartRepository.save(cart);
        }

        Cart cart = cartRepository.findByUser(user).get();

        CartItem cartItem = new CartItem(cart, item, req.getQuantity());
        cartItemRepository.save(cartItem);
    }

    // 장바구니 조회
    @Transactional(readOnly = true)
    public List<CartItemResponseDto> findAll(User user) throws Exception{
        Cart cart = cartRepository.findByUser(user).orElseThrow(ChangeSetPersister.NotFoundException::new);

        List<CartItem> cartItems = cartItemRepository.findAllByCart(cart);
        List<CartItemResponseDto> result = new ArrayList<>();

        cartItems.stream().forEach(cartItem -> {
            result.add(new CartItemResponseDto().toDto(cartItem));
        });

        return result;
    }

    // 장바구니 품목 단건 삭제
    @Transactional
    public void deleteById(Long id, User user) throws Exception{
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        Cart cart = cartItem.getCart();

        if (!cart.getUser().equals(user)) {
            throw new ChangeSetPersister.NotFoundException();
        }

        cartItemRepository.delete(cartItem);
    }

    // 장바구니 주문하기
    @Transactional
    public void orderAll(User user, String actId) throws Exception {
        Cart cart = cartRepository.findByUser(user).orElseThrow(ChangeSetPersister.NotFoundException::new);
        List<CartItem> cartItems = cartItemRepository.findAllByCart(cart);
        Account account = accountRepository.findById(actId).orElseThrow(ChangeSetPersister.NotFoundException::new);

        cartItems.stream().forEach(cartItem -> {
            Item item = cartItem.getItem();

            //checkMemberCanBuyCartItemForEach(item, user, cartItem);

        // 재고처리
        //item.setQuantity(item.getQuantity() - cartItem.getQuantity());
        });

        orderService.create(cart, account);
    }

//    public boolean checkMemberCanBuyCartItemForEach(Item item, CartItem cartItem) {
//        // 구매 수량 체크
//        if (cartItem.getQuantity() > item.getQuantity()) {
//            throw new LakingOfProductQuantity();
//        }
//
//        return true;
//    }
}