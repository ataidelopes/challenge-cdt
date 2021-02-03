package com.conductor.challengecdt.controller.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Long id;
    private String description;
    private BigDecimal unitPrice;
    private Integer quantity;

}
