package com.conductor.challengecdt.service.events;

import com.conductor.challengecdt.controller.dto.PaymentDto;
import org.springframework.context.ApplicationEvent;

public abstract class PaymentEventAbstract extends ApplicationEvent {

    private final PaymentDto paymentDto;

    public PaymentEventAbstract(PaymentDto paymentDto, Object source) {
        super(source);
        this.paymentDto = paymentDto;
    }

    public PaymentDto getPaymentDto() {
        return paymentDto;
    }
}

