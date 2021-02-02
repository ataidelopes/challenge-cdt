package com.conductor.serviceorder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum Province {

    AC("Acre","AC"),
    AL("Alagoas","AL"),
    AP("Amapá","AP"),
    AM("Amazonas","AM"),
    BA("Bahia","BA"),
    CE("Ceará","CE"),
    ES("Espírito Santo","ES"),
    GO("Goiás","GO"),
    MA("Maranhão","MA"),
    MT("Mato Grosso","MT"),
    MS("Mato Grosso do Sul","MS"),
    MG("Minas Gerais","MG"),
    PA("Pará","PA"),
    PB("Paraíba","PB"),
    PR("Paraná","PR"),
    PE("Pernambuco","PE"),
    PI("Piauí","PI"),
    RJ("Rio de Janeiro","RJ"),
    RN("Rio Grande do Norte","RN"),
    RS("Rio Grande do Sul","RS"),
    RO("Rondônia","RO"),
    RR("Roraima","RR"),
    SC("Santa Catarina","SC"),
    SP("São Paulo","SP"),
    SE("Sergipe","SE"),
    TO("Tocantins","TO"),
    DF("Distrito Federal","DF");

    private String province;
    private String state;
}
