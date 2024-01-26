package io.github.chriseteka.paystackclient.domain;

import java.util.stream.Stream;

public enum Currency {

    NGN("Kobo", "Nigerian Naira"),
    USD("Cent", "United States Dollar"),
    GHS("Pesewa", "Ghanaian Cedi"),
    ZAR("Cent", "South African Rand"),
    KES("Cent", "Kenyan Shilling");

    private final String baseUnit;
    private final String description;

    Currency(String baseUnit, String description) {
        this.baseUnit = baseUnit;
        this.description = description;
    }

    public static Currency fromIgnoreCase(String searchString) {
        final String searchStringUpperCase = searchString.toUpperCase();
        return Stream.of(values())
                .filter(v -> v.name().equalsIgnoreCase(searchStringUpperCase)
                        || v.baseUnit.toUpperCase().equalsIgnoreCase(searchStringUpperCase)
                        || v.description.toUpperCase().equalsIgnoreCase(searchStringUpperCase))
                .findFirst()
                .orElseThrow();
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public String getDescription() {
        return description;
    }
}
