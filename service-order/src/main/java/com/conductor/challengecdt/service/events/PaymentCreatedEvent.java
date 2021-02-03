package com.conductor.challengecdt.service.events;

import com.conductor.challengecdt.controller.dto.PaymentDto;

public class PaymentCreatedEvent extends PaymentEventAbstract {

    public PaymentCreatedEvent(PaymentDto paymentDto, Object source) {
        super(paymentDto, source);
    }
}
