package com.dai.wos.domain.cart.service;

import com.dai.wos.domain.account.entity.Account;
import com.dai.wos.domain.account.repository.AccountRepository;
import com.dai.wos.domain.cart.entity.Cart;
import com.dai.wos.domain.cart.repository.CartRepository;
import com.dai.wos.domain.cartItem.controller.dto.CartItemRequestDto;
import com.dai.wos.domain.cartItem.controller.dto.CartItemResponseDto;
import com.dai.wos.domain.cartItem.entity.CartItem;
import com.dai.wos.domain.cartItem.repository.CartItemRepository;
import com.dai.wos.domain.cartItem.service.CartItemService;
import com.dai.wos.domain.category.entity.Category;
import com.dai.wos.domain.category.repository.CategoryRepository;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.item.repository.ItemRepository;
import com.dai.wos.domain.owner.entity.Owner;
import com.dai.wos.domain.owner.repository.OwnerRepository;
import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CartServiceTest {
    // 화주 생성
    @Autowired
    OwnerRepository ownerRepository;
    // 거래처 생성
    @Autowired
    AccountRepository accountRepository;
    // 사용자 생성
    @Autowired
    UserRepository userRepository;
    // 상품 생성
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartRepository cartRepository;

    // 장바구니 상품 생성
    @Autowired
    CartService cartService;

    public Owner saveOwner() {
        Owner owner = Owner.builder()
                .ownerId("A123")
                .ownerNm("donga")
                .build();
        return ownerRepository.save(owner);
    }

    public Account saveAccount() {
        Account account = Account.builder()
                .accountId("B123")
                .accountNm("동아치과")
                .zipCd("1")
                .addr1("서울특별시 마포구 성미산로")
                .taxNo("0123456789")
                .build();
        return accountRepository.save(account);
    }

    public User saveUser(Owner owner) {
        User user = User.builder()
                .userId("user123")
                .userPwd("123456")
                .userNm("박진서")
                .owner(owner)
                .build();
        return userRepository.save(user);
    }

    public Category saveCategory() {
        Category category = Category.builder()
                .categoryId("cate123")
                .categoryNm("비타민C")
                .build();

        return categoryRepository.save(category);
    }

    public Item saveItem(Owner owner, Category category) {
        Item item = Item.builder()
                .itemId("i123")
                .itemNm("박카스")
                .owner(owner)
                .category(category)
                .quantity(10)
                .unit("box")
                .build();
        return itemRepository.save(item);
    }

    @Test
    @DisplayName("장바구니 담기 테스트")
    public void addCart() throws Exception {
        Owner owner = saveOwner();
        Account account = saveAccount();
        User user = saveUser(owner);
        Category category = saveCategory();
        Item item = saveItem(owner,category);

        CartItemRequestDto req = new CartItemRequestDto();
        req.setItemId(item.getItemId());
        req.setQuantity(5);

        // 재고보다 적은 경우 (주문 가능)
        cartService.create(req, user.getUserId());
        //cartService.create(req, user.getUserId());
        Cart cart = cartRepository.findByUser(user).get();
        CartItem cartItem = cartItemRepository.findByCartIdAndItemId(cart.getCartId(), item.getItemId()).get();
        Item item1 = itemRepository.findById(item.getItemId()).get();

        assertEquals(item.getItemId(), cartItem.getItem().getItemId());
        assertEquals(req.getQuantity(), cartItem.getQuantity());

    }

    @Test
    @DisplayName("장바구니 조회")
    public void findAll() throws Exception {
        List<CartItemResponseDto> cartItems = cartService.findAll("user123");
        assertEquals(cartItems.size(), 1);
    }

    @Test
    @DisplayName("장바구니 상품 삭제")
    public void deleteItem() {

    }

    @Test
    @DisplayName("장바구니 비우기")
    public void reset() {

    }

    @Test
    @DisplayName("장바구니 주문하기")
    public void order() {

    }
}