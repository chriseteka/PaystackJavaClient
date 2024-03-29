package io.github.chriseteka.paystackclient.domain.product;

import io.github.chriseteka.paystackclient.domain.Amount;
import io.github.chriseteka.paystackclient.domain.request.RequestBody;

public class CreateOrUpdateProductRequest implements RequestBody<CreateOrUpdateProductRequest> {
    private final String name;
    private final String description;
    private final String price;
    private final String currency;
    private boolean unlimited;
    private Integer quantity;

    public CreateOrUpdateProductRequest(String name, String description, Amount price){
        this.name = name;
        this.description = description;
        this.price = price.getUnitValue();
        this.currency = price.getCurrency().name();
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

    public CreateOrUpdateProductRequest unlimited(boolean unlimited) {
        this.unlimited = unlimited;
        return this;
    }

    public CreateOrUpdateProductRequest quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
