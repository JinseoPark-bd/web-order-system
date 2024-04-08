package com.dai.wos.domain.item.service;

import com.dai.wos.domain.cart.entity.CartItem;
import com.dai.wos.domain.item.controller.dto.ItemResponseDto;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.item.repository.ItemRepository;
import com.dai.wos.domain.owner.entity.Owner;
import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    // 아이템 리스트 불러오기
//    public List<ItemResponseDto> findAllByOwner (String userId) {
//        User user = userService.findById(userId);
//        return itemRepository.findAllByOwner(user.getOwner()).stream()
//                .map(item -> ItemResponseDto.toDto(item))
//                .collect(Collectors.toList());
//    }

    // 아이템 리스트 불러오기 query
    public void findAllByOwner_2 (String ownerId) {

    }

    // 아이템 아이디로 검색
    public ItemResponseDto findById(String itemId) {
        return ItemResponseDto.toDto(itemRepository.findById(itemId).orElseThrow());
    }

    // 재고 처리
    /**
     * 1. 주문 생성
     * 2. 상품의 재고와 주문상품의 수량 비교
     * 3. OrderService에서 -> ItemService 호출
     *
     */
    @Transactional
    public Item updateQuantity(CartItem cartItem) {
        Item item = itemRepository.findById(cartItem.getItem().getItemId()).orElseThrow();
        item.updateQuantity(cartItem.getQuantity());
        return item;
    }

}
