package com.conductor.challengecdt.controller.mapper;

import com.conductor.challengecdt.controller.dto.AddressDto;
import com.conductor.challengecdt.model.Address;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper extends ConfigurableMapper  implements ValidateMapper<AddressDto> {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Address.class, AddressDto.class)
                .field("province", "province.state")
                .byDefault().register();
    }
}
