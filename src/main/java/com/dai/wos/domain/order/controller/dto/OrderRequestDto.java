package com.dai.wos.domain.order.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private Date startDate;
    private Date endDate;
    private String actId;
}
