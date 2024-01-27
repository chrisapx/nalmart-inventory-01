package com.cwift.cwiftMarketplace_backend.model;

import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CwiftPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userID;
    private String userEmail;
    private double accountBalance;

    private String accountNumber = IDGenerator.accountNumber ();

}
