package com.dai.wos.domain.item.controller;

import com.dai.wos.domain.item.controller.dto.ItemResponseDto;
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

    // 상품 전체 조회
    @GetMapping("")
    @PreAuthorize("isAuthenticated()")
    public List<ItemResponseDto> findAll(@AuthenticationPrincipal User user) {
        return itemService.findAll(user.getUsername());
    }

    // 상품 검색
    @GetMapping("/search")
    @PreAuthorize("isAuthenticated()")
    public List<ItemResponseDto> searchItem(
            @RequestParam String cateId,
            @RequestParam String keyword,
            @AuthenticationPrincipal User user) {
        return itemService.findByKeyword(user.getUsername(), cateId, keyword);
    }
}
