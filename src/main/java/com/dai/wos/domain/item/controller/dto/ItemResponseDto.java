package com.dai.wos.domain.item.controller.dto;

import com.dai.wos.domain.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {
    private String itemId;
    private String itemNm;
    private Integer quantity;
    private String unit;

    public static ItemResponseDto toDto(Item item) {
        return new ItemResponseDto(
                item.getItemId(),
                item.getItemNm(),
                item.getQuantity(),
                item.getUnit()
        );
    }
}
