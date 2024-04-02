package com.dai.wos.domain.item.controller;

import com.dai.wos.domain.item.entity.Item;
import com.dai.wos.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class ItemController {
    private final ItemService itemService;

    @ResponseBody
    @PostMapping("")
    public Item itemPost(@RequestBody Item item) {
        return new Item();
    }
}
