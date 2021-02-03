package com.conductor.challengecdt.controller.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {

    private String creditCardNumber;
    private Long identityOrder;

}
