package com.cwift.cwiftMarketplace_backend.model;

import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemID;

    @NotNull(message = "Item name must not be null and should be unique")
    @Column(unique = true)
    private String name;
    @NotNull(message = "Item name must not be null and should be unique")
    @Column(unique = true)
    private String displayName;
    @NotNull(message = "qty must not be null")
    private String qty;
    @Column(length = 1000)
    private String description;
    private double globalPrice;
    @NotNull(message = "Item price must not be null")
    private double price;
//    @JsonIgnore
    private double discount;
    @NotNull(message = "Free delivery must not be null")
    private boolean freeDelivery;
    private int stockCount;
    private String brand;
    private String serialNumber;
    private long vendorID;
    private String Store;
    private boolean approved;
    private String whatIsInTheBox;
    private Type type;
    private String category;
    private String subCategory;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Details> details;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> photos;
    @OneToOne(cascade = CascadeType.ALL)
    private Image coverPhoto;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> ads;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Column(unique = true)
    private String sku = IDGenerator.itemIDGenerator ();
    @Temporal(TemporalType.DATE)
    private Date dateCreated = new Date ();
    private Date dateModified;
}
