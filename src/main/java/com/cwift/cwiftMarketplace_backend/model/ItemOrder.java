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

    private String itemID;
    private int quantity;
    private String specialInstructions;
    private Date dateModified;

    private String orderID = IDGenerator.orderIDGenerator ();
    private Date dateCreated = new Date ();
}
