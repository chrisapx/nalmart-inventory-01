package com.cwift.cwiftMarketplace_backend.model;

import io.swagger.annotations.ApiModel;

//@ApiModel(description = "Order status options")
public enum OrderStatus {
    COMPLETED("Order has been completed"),
    CONFIRMED("Order has been confirmed"),
    CANCELLED("Order has been cancelled"),
    IN_PROGRESS("Order is in progress"),
    SHIPPED("Order has been shipped"),
    OUT_FOR_DELIVERY("Order is out for delivery"),
    DELIVERED("Order has been delivered"),
    OUT_FOR_RETURN("Order is out for return"),
    RETURNED("Order has been returned");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
