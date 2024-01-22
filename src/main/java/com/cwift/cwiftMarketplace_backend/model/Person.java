package com.cwift.cwiftMarketplace_backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String firstname;
    private String lastname;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    @Column(unique = true)
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
