package com.cwift.cwiftMarketplace_backend.model;

import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Item item;
    private int quantity;
    @NotNull
    private String userID;
    private double totalPrice;
    private boolean paid;
    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;
    private String specialInstructions;

    private String orderID = IDGenerator.orderIDGenerator ();
    private Date dateCreated = new Date ();
}
