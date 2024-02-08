package com.cwift.cwiftMarketplace_backend.model;

import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @NotNull(message = "phone must not be null")
    private String phone;
    @NotNull(message = "Account number must not be null")
    @JsonIgnore
    private long accountNumber;
    @NotNull(message = "Expiry date must not be null")
    @JsonIgnore
    private Date expiryDate;
    @NotNull(message = "CVV must not be null")
    @JsonIgnore
    private long cvv;
    @NotNull(message = "Bank name must not be null")
    private String bankName;
    @NotNull(message = "Account name must not be null")
    private String accountName;
    @NotNull(message = "Provider must not be null")
    private String provider;
    private Status status;
    private Date modifiedAt;
    private boolean received;  //Also create an API for the user to approve receive of the payment

    private Date createdAt = new Date ();
    private String transactionID = IDGenerator.transIDGenerator ();

}
