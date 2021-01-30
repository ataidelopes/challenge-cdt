package com.conductor.challengecdt.controller.mapper;

import com.conductor.challengecdt.controller.dto.StoreDto;
import com.conductor.challengecdt.model.Store;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Store.class, StoreDto.class)
                .byDefault().register();
    }
}
