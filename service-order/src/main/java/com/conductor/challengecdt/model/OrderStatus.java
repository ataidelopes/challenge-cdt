package com.conductor.challengecdt.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum OrderStatus {

    CREATED,
    PENDING_PAYMENT,
    CONFIRMED,
    CANCELED,
    PENDING_REFUND,
    REFUND_CONFIRMED
}
