package com.conductor.challengecdt.service.impl;

import com.conductor.challengecdt.controller.dto.OrderDto;
import com.conductor.challengecdt.controller.mapper.OrderMapper;
import com.conductor.challengecdt.model.Order;
import com.conductor.challengecdt.model.OrderStatus;
import com.conductor.challengecdt.repository.OrderRepository;
import com.conductor.challengecdt.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


/**
 * class to represent order orders
 */
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto created(final OrderDto orderDto) {
        Order orderSaved = orderRepository.save(getObjectPersisteOrder(orderDto));
        return orderMapper.map(orderSaved, OrderDto.class);
    }

    @Override
    public OrderDto findById(final Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Order.class.getSimpleName()));
        return orderMapper.map(order, OrderDto.class);
    }

    @Override
    public OrderDto update(final Long id, final OrderDto storeDto) {
        return null;
    }

    /**
     * method to converter a StoreDto object to order entity
     *
     * @param orderDto object for transform in entity
     * @return object mapper to Entity Store
     */
    private Order mapperStoreDtoForEntity(final OrderDto orderDto) {
        return orderMapper.validateMapperOfNullabe(orderDto, orderMapper).map(orderDto, Order.class);
    }

    private Order getObjectPersisteOrder(final OrderDto orderDto) {
        val orderObjMapper = mapperStoreDtoForEntity(orderDto);
        orderObjMapper.setDateOrder(LocalDate.now());
        orderObjMapper.setOrderStatus(OrderStatus.CREATED);
        return orderObjMapper;
    }
}
