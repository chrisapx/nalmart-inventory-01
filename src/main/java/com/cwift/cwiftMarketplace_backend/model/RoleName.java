package com.cwift.cwiftMarketplace_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public enum RoleName {

    USER("These are normal customers of products"),
    ADMIN("These are responsible for order process pipeline"),
    FINANCE_MANAGER("This is responsible for system finances"),
    SUPER_ADMIN("These are responsible for system management and error check"),
    DELIVERY_AGENT("These are responsible for order delivery"),
    VENDOR("These are the ones responsible for item selling and stocking"),
    CUSTOMER_ST("Soroti customer")
    ;

    private final String description;

    RoleName ( String description ) {
        this.description = description;
    }
}