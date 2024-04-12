package com.dai.wos.domain.item.service;

import com.dai.wos.domain.cartItem.entity.CartItem;
import com.dai.wos.domain.item.controller.dto.ItemResponseDto;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.item.repository.ItemRepository;
import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;


    // 상품ID로 조회
    public ItemResponseDto findById(String itemId) {
        return ItemResponseDto.toDto(itemRepository.findById(itemId).orElseThrow());
    }

    // entity 가져오기 (장바구니 상품 생성용)
    public Item getById (String itemId) throws Exception{
        return itemRepository.findById(itemId).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

     // 상품 리스트
    public List<ItemResponseDto> findAll (String userId) {
        User user = userService.findById(userId);
        return itemRepository.findAll(user.getOwner().getOwnerId()).stream()
                .map(item -> ItemResponseDto.toDto(item))
                .collect(Collectors.toList());
    }


    // 상품 검색
    public List<ItemResponseDto> findByKeyword(String userId, String categoryId, String keyword) {
        User user = userService.findById(userId);
        String ownerId = user.getOwner().getOwnerId();
        return itemRepository.findByKeyword(ownerId, categoryId, keyword).stream()
                .map(item -> ItemResponseDto.toDto(item))
                .collect(Collectors.toList());
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
