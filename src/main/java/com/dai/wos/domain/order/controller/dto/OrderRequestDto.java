package com.dai.wos.domain.order.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private String actId;
}
