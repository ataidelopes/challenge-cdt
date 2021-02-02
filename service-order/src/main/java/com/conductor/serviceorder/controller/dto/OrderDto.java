package com.conductor.serviceorder.controller.dto;

import com.conductor.serviceorder.model.Status;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

//    private Address address;

    private LocalDate dateConfirmation;
    private Status status;
    private Set<ItemDto> itens;
}
