package com.cwift.cwiftMarketplace_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


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
