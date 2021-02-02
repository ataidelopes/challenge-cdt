package com.conductor.serviceorder.controller.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private String description;
    private BigDecimal unitPrice;
    private Integer quantity;

}
