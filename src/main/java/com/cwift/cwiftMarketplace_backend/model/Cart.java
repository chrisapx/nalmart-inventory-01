package com.cwift.cwiftMarketplace_backend.model;

import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemOrder> itemOrders;
    private double totalPrice;
    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;
    private String specialInstructions;
    private boolean paid;
    @Column(unique = true)
    private String userID;
    private String userEmail;

    private Date modifiedAt;
    @Column(unique = true)
    private String cartID = IDGenerator.cartIDGenerator ();
    private Date createdAt = new Date ();
}
