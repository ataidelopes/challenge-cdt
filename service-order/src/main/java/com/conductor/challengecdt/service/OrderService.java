package com.conductor.challengecdt.service;

import com.conductor.challengecdt.controller.dto.OrderDto;

public interface OrderService {

    OrderDto created(OrderDto order);

    OrderDto findById(Long id);

    OrderDto update(Long id, OrderDto storeDto);

    OrderDto makePayment(Long id, String numberCard);
}
