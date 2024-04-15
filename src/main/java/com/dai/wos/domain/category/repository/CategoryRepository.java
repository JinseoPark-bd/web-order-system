package com.dai.wos.domain.category.repository;

import com.dai.wos.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findAllByCategoryNm(String categoryNm);
}
