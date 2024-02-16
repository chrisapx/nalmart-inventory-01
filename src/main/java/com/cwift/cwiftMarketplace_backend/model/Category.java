package com.cwift.cwiftMarketplace_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum Category {

    AUTOMOBILE("Automobile", List.of ()),
    BABY_PRODUCTS("Baby products", List.of ()),
    BOOKS_MOVIES_AND_MUSIC("Books, Movies and Music", List.of ()),
    COMPUTING("Computing", List.of ()),
    ELECTRONICS("Electronics", List.of ()),
    FASHION("Fashion", List.of ()),
    GAMING("Gaming", List.of ()),
    GARDEN_AND_OUTDOORS("Garden & Outdoor", List.of ()),
    SUPERMARKET("Supermarket", List.of ()),
    HEALTH_AND_BEAUTY("Health & Beauty", List.of ()),
    HOME_AND_OFFICE("Home & office", List.of ()),
    INDUSTRY_AND_SCIENTIFIC("Industry & scientific", List.of ()),
    LIVESTOCK("Livestock", List.of ()),
    MUSIC_INSTRUMENTS("Musical instruments", List.of ()),
    PET_SUPPLIES("Pet supplies", List.of ()),
    PHONE_AND_TABLETS("Phone & Tablets", List.of ()),
    SPORTING_GOODS("Sporting Goods", List.of ()),
    TOYS_AND_GAMES("Toys & Games", List.of ()),
    WHOLESALE("Whole sale", List.of ());

    private final String categoryID;
    private final List<SubCategory> subCategories;

//    Category ( String categoryID, List<SubCategory> subCategories ) {
//        this.categoryID = categoryID;
//        this.subCategories = subCategories;
//    }
//
//    Category ( String categoryID ) {
//        this.categoryID = categoryID;
//    }
//    @Getter
//    private final List<SubCategory> subCategories;

//    Category ( String categoryID, List<SubCategory> subCategories ) {
//        this.categoryID = categoryID;
//        this.subCategories = subCategories;
//    }


}
