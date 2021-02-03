package com.conductor.challengecdt.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

/**
 *  Entity represent a entity OrderItem
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
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "description cannot null")
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String description;

    @NotNull(message = "unit price cannot null")
    @Positive
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal unitPrice;

    @NotNull(message = "quantity cannot be null or less than zero")
    @Positive
    @Column(nullable = false)
    private Integer quantity;

}
