package com.cwift.cwiftMarketplace_backend.model;

import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemID;

    @NotNull(message = "Item name must not be null")
    @Column(unique = true)
    private String name;
    @NotNull(message = "qty must not be null")
    private String qty;
    private String description;
    @NotNull(message = "Item price must not be null")
    private double price;
    private double discount;
    @NotNull(message = "Free delivery must not be null")
    private boolean freeDelivery;
    private int stockCount;
    private String Brand;
    private String serialNumber;
    private long vendorID;
    @Enumerated(EnumType.STRING)
    private Original original;
    @Enumerated(EnumType.STRING)
    private Category category;
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

//    @JsonIgnore
    @Column(unique = true)
    private String sku = IDGenerator.itemIDGenerator ();

}
