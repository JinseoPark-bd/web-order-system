package com.dai.wos.domain.category.controller.dto;


import com.dai.wos.domain.category.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {
    @NotNull
    @Size(min = 3, max = 50)
    private String id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    private String etc;

    public static TestDto toDto(Category category) {
        return new TestDto(category.getCategoryId(), category.getCategoryNm(), "안녕하세요.");
    }
}
