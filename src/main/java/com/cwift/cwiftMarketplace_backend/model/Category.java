package com.cwift.cwiftMarketplace_backend.model;

public enum Category {

    AUTOMOBILE("Automobile"),
    BABY_PRODUCTS("Baby products"),
    BOOKS_MOVIES_AND_MUSIC("Books, Movies and Music"),
    COMPUTING("Computing"),
    ELECTRONICS("Electronics"),
    FASHION("Fashion"),
    GAMING("Gaming"),
    GARDEN_AND_OUTDOORS("Garden & Outdoor"),
    SUPERMARKET("Supermarket"),
    HEALTH_AND_BEAUTY("Health & Beauty"),
    HOME_AND_OFFICE("Home & office"),
    INDUSTRY_AND_SCIENTIFIC("Industry & scientific"),
    LIVESTOCK("Livestock"),
    MUSIC_INSTRUMENTS("Musical instruments"),
    PET_SUPPLIES("Pet supplies"),
    PHONE_AND_TABLETS("Phone & Tablets"),
    SPORTING_GOODS("Sporting Goods"),
    TOYS_AND_GAMES("Toys & Games"),
    WHOLESALE("Whole sale");

    private final String categoryID;
    private final SubCategory[] subCategories;

    Category ( String categoryID, SubCategory... subCategories ) {
        this.categoryID = categoryID;
        this.subCategories = subCategories;
    }
}
