package com.dai.wos.domain.cartItem.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemRequestDto {
    @NotNull(message = "상품 코드를 입력하세요.")
    private String itemId;

    @NotNull(message = "구매 수량을 입력하세요.")
    @Min(value = 1, message = "최소 1개 이상 담아주세요.")
    private Integer quantity;

}
