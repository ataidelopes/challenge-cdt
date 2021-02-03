package com.conductor.challengecdt.controller.mapper;

import com.conductor.challengecdt.controller.dto.StoreDto;
import com.conductor.challengecdt.model.Store;
import common.mapper.ValidateMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper extends ConfigurableMapper implements ValidateMapper<StoreDto> {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Store.class, StoreDto.class)
                .byDefault().register();
    }


}
