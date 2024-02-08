package com.cwift.cwiftMarketplace_backend.model;

import com.cwift.cwiftMarketplace_backend.utils.IDGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String itemName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Details> itemDetails;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> samplePics;
    private Date expectedDate;

    private String CustomItemSku = IDGenerator.customItemSkuGenerator ();
    private Date dateCreated = new Date ();

}
