package com.dai.wos.domain.category.service;

import com.dai.wos.domain.category.controller.dto.TestDto;
import com.dai.wos.domain.category.entity.Category;
import com.dai.wos.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void createCategory (TestDto req) {
        Category cate = new Category(req.getId(), req.getName());
        categoryRepository.save(cate);
    }

    public List<TestDto> findAllCategories (String name) {
        List<Category> categories = categoryRepository.findAllByCateNm(name);
        return categories.stream()
                .map(TestDto::toDto)
                .collect(Collectors.toList());
    }

}
