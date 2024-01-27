package com.cwift.cwiftMarketplace_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long detailsID;

    private String name;
    private String value;
}
