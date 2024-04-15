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

    private long itemID;
    private String cartID;
    private String userID;
    private int quantity;
    private String specialInstructions;

    private Date deliveryDate;
    private Date dateModified;
    private OrderStatus orderStatus;

    private String orderID = IDGenerator.orderIDGenerator ();
    private Date dateCreated = new Date ();
}
