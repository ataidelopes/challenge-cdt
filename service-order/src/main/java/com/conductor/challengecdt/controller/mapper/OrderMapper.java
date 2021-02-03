package com.conductor.challengecdt.controller.mapper;

import com.conductor.challengecdt.controller.dto.OrderDto;
import com.conductor.challengecdt.model.Order;
import common.mapper.ValidateMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper  extends ConfigurableMapper implements ValidateMapper<OrderDto> {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Order.class, OrderDto.class)
                .byDefault().register();
    }
}
