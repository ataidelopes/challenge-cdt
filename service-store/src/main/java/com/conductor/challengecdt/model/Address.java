package com.conductor.challengecdt.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Column()
    private String complement;

    @Column()
    private Integer number;

    @NotNull(message = "The field state is mandatory")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", insertable = false, updatable = false)
    private Province state;

}
