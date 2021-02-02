package com.conductor.serviceorder.model.converter;

import com.conductor.serviceorder.model.Province;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProvinceEnumConverter implements AttributeConverter<Province, String> {

    @Override
    public String convertToDatabaseColumn(Province province) {
        return Optional.ofNullable(province).orElse(null).getState();
    }

    @Override
    public Province convertToEntityAttribute(String state) {
        return Stream.of(Province.values())
                        .filter(c -> c.getState().equals(state))
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
    }
}

