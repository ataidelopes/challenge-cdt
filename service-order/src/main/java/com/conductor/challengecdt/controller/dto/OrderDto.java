package com.conductor.challengecdt.controller.dto;

import com.conductor.challengecdt.model.OrderStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private LocalDate dateOrder;
    private OrderStatus orderStatus;
    private AddressDto address;
    private List<ItemDto> items;
}
