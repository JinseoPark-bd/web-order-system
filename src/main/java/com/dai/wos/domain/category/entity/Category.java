package com.dai.wos.domain.category.entity;

import com.dai.wos.baseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Getter
@NoArgsConstructor
@Entity(name = "OJT_OMS_CATEGORY_JPA")
public class Category {

    @Id
    @Column(length = 25)
    private String categoryId;

    @Column(nullable = false, length = 25)
    private String categoryNm;

    @Builder
    private Category(String categoryId, String categoryNm) {
        this.categoryId = categoryId;
        this.categoryNm = categoryNm;
    }

}
