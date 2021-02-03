package com.conductor.challengecdt.service;

import com.conductor.challengecdt.controller.dto.OrderDto;
import org.hibernate.ObjectNotFoundException;

public interface OrderService {

    OrderDto created(OrderDto order);

    OrderDto findById(Long id);

    OrderDto update(Long id, OrderDto storeDto);
}
