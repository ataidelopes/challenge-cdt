package com.conductor.challengecdt.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {

    private String street;
    private Integer number;
    private ProvinceDto state;
    private String complement;
    private String postalCode;
}
