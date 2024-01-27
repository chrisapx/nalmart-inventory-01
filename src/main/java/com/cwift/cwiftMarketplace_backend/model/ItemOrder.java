package com.cwift.cwiftMarketplace_backend.model;

import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String userID;
    private double totalPrice;

    private String orderID = IDGenerator.orderIDGenerator ();
    private Date dateCreated = new Date ();
}
