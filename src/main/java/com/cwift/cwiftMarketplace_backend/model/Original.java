package com.cwift.cwiftMarketplace_backend.model;

public enum Original {

    ORIGINAL("This is a copy of the original"),
    COPY("This is a copy of the original");

    private final String description;

    Original ( String description ) {
        this.description = description;
    }
}
