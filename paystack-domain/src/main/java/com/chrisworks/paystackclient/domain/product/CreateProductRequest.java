package com.chrisworks.paystackclient.domain.product;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.request.RequestBody;

public class CreateProductRequest implements RequestBody<CreateProductRequest> {
    private final String name;
    private final String description;
    private final String price;
    private final String currency;
    private final boolean unlimited;
    private final Integer quantity;

    public CreateProductRequest(String name, String description, Amount price, boolean unlimited, Integer quantity){
        this.name = name;
        this.description = description;
        this.price = price.getUnitValue();
        this.currency = price.getCurrency().name();
        this.unlimited = unlimited;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isUnlimited() {
        return unlimited;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
