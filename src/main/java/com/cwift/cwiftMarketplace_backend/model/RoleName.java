package com.cwift.cwiftMarketplace_backend.model;

public enum RoleName {

    USER("These are normal customers of products"),
    ADMIN("These are responsible for order process pipeline"),
    DELIVERY_AGENT("These are responsible for order delivery"),
    VENDOR("These are the ones responsible for item selling and stocking"),
    ;

    private final String description;

    RoleName ( String description ) {
        this.description = description;
    }
}
