package com.chrisworks.paystackclient.domain.product;

import com.chrisworks.paystackclient.domain.Amount;

public final class UpdateProductRequest extends CreateProductRequest {

    private UpdateProductRequest (String name, String description, Amount price, boolean unlimited, Integer quantity){
        super(name, description, price, unlimited, quantity);
    }

}
