package com.dai.wos.domain.order.controller.dto;

import com.dai.wos.domain.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private String ymd; //주문 일자
    private Long seq; //주문 번호
    private String actId; //거래처코드
    private String actNm; //거래처명
    private String itemId; //제품코드
    private String itemNm; // 제품 명
    private int quantity; //주문 수량

    public static OrderResponseDto toDto (Order order) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String ymd = dateFormat.format(order.getCreateDt());
        return new OrderResponseDto(
                ymd,
                order.getSeq(),
                order.getAccount().getActId(),
                order.getActNm(),
                order.getItem().getItemId(),
                order.getItemNm(),
                order.getQuantity()
        );
    }
}
