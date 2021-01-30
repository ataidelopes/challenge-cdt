package com.conductor.challengecdt.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "The field full Name is mandatory")
    @Column(nullable = false)
    private String fullName;

    @NotNull(message = "The field full Name is mandatory")
    @Column(nullable = false, length = 2, unique = true)
    private String state;

}
