package com.conductor.challengecdt.service.impl;

import com.conductor.challengecdt.controller.dto.OrderDto;
import com.conductor.challengecdt.controller.dto.PaymentDto;
import com.conductor.challengecdt.controller.mapper.OrderMapper;
import com.conductor.challengecdt.model.Order;
import com.conductor.challengecdt.model.OrderStatus;
import com.conductor.challengecdt.repository.OrderRepository;
import com.conductor.challengecdt.service.OrderService;
import com.conductor.challengecdt.service.events.PaymentCreatedEvent;
import common.exception.BusinessRulesExceptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
    private final ApplicationEventPublisher applicationEventPublisher;

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

    @Override
    public OrderDto makePayment(Long id, String numberCard) {

        Long idOrder = orderRepository.findByIdAndOrderStatusEqualsCreated(id)
                .orElseThrow(() -> new BusinessRulesExceptions("unable to locate order to make payment"))
                .getId();

        PaymentDto paymentDto = createdObjectOrderPayment(idOrder, numberCard);
        applicationEventPublisher.publishEvent(new PaymentCreatedEvent(paymentDto, this));
        this.updateStatusOrder(idOrder, OrderStatus.PENDING_PAYMENT);

        return null;
    }

    public void updateStatusOrder(Long id, OrderStatus status){
        orderRepository.findById(id)
                .ifPresent(order -> {
                    order.setOrderStatus(status);
                    orderRepository.save(order);
                });
    }

    /**
     * method to converter a orderDto object to order entity
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

    private PaymentDto createdObjectOrderPayment(Long id, String numberCreditCard) {
        return PaymentDto.builder()
                .creditCardNumber(numberCreditCard)
                .identityOrder(id).build();
    }
}
