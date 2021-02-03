package com.conductor.challengecdt.service.integration;

import com.conductor.challengecdt.controller.dto.PaymentDto;
import com.conductor.challengecdt.service.events.PaymentCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventPaymentListener {

    private final RabbitTemplate rabbitTemplate;

    public EventPaymentListener(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void onPaymentOrder(PaymentCreatedEvent paymentCreatedEvent){
        publish(paymentCreatedEvent.getPaymentDto(), "payment");
    }

    public void publish(PaymentDto paymentDto, String routerKey){
        rabbitTemplate.convertAndSend(routerKey, paymentDto);
    }
}
