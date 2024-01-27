package com.cwift.cwiftMarketplace_backend.model;

import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderID;
    @NotNull(message = "Amount must not be null")
    private double amount;
    private String phone;
    private long accountNumber;
    private Date expiryDate;
    private long cvv;
    private String bankName;
    private String accountName;
    private String provider;
    private Status status;
    private Date modifiedAt;

    private Date createdAt = new Date ();
    private String transactionID = IDGenerator.transIDGenerator ();

}
