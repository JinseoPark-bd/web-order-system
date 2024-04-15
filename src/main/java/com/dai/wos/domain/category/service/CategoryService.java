package com.dai.wos.domain.category.service;

import com.dai.wos.domain.category.controller.dto.TestDto;
import com.dai.wos.domain.category.entity.Category;
import com.dai.wos.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<TestDto> findAllCategories (String name) {
        List<Category> categories = categoryRepository.findAllByCategoryNm(name);
        return categories.stream()
                .map(TestDto::toDto)
                .collect(Collectors.toList());
    }

}
