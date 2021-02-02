package com.conductor.challengecdt.model;


import lombok.*;

import javax.persistence.*;
import javax.swing.plaf.nimbus.State;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 *  Entity represent a entity Address
 * @author Rodrigo
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "The field street is mandatory")
    @Column(nullable = false)
    private String street;

    @NotNull(message = "The field postalCode is mandatory")
    @Column(nullable = false)
    private String postalCode;

    @Column
    private String complement;

    @Column
    private Integer number;

    @Enumerated(EnumType.STRING)
    @Column(length = 2, nullable = false)
    private Province province;

}
