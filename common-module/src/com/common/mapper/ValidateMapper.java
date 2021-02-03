package common.mapper;

import common.exception.BusinessRulesExceptions;
import ma.glasnost.orika.impl.ConfigurableMapper;

import java.util.Optional;

public interface ValidateMapper<T> {

    default ConfigurableMapper validateMapperOfNullabe(T dto, ConfigurableMapper configurableMapper) {
        Optional.ofNullable(dto).orElseThrow(() -> new BusinessRulesExceptions("store object cannot be null"));
        return configurableMapper;
    }
}
