package com.dai.wos.domain.category.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OJT_OMS_CATEGORY_JPA")
public class Category {

    @Id
    private String cateId;

    @Column(nullable = false)
    private String cateNm;

}
