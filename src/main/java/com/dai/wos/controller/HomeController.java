package com.dai.wos.controller;

import com.dai.wos.domain.item.entity.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/home")
    public List<String> test() {
        return Arrays.asList("서버 포트는 8080", "리액트 포트는 3000");
    }
}
