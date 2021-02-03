package com.conductor.challengecdt.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import common.enumaration.Province;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {

    private Long id;
    private String street;
    private Integer number;
    private Province province;
    private String complement;
    private String postalCode;
}
