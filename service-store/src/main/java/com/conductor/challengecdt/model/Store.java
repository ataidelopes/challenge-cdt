package com.conductor.challengecdt.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *  Entity represent a entity Store
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
public class Store implements AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "The field name is mandatory")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "The field address is mandatory")
    @OneToOne(cascade=CascadeType.PERSIST)
    private Address address;

}
