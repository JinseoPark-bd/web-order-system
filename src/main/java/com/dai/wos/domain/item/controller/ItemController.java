package com.dai.wos.domain.item.controller;

import com.dai.wos.domain.item.controller.dto.ItemResponseDto;
import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;

    //상품 조회
//    @GetMapping("/list")
//    @PreAuthorize("isAuthenticated()")
//    public List<ItemResponseDto> findAll(@AuthenticationPrincipal User user) {
//        return itemService.findAllByOwner(user.getUsername());
//    }

    @GetMapping("/{itemId}")
    public ItemResponseDto findById(@PathVariable String itemId) {
        return itemService.findById(itemId);
    }
}
