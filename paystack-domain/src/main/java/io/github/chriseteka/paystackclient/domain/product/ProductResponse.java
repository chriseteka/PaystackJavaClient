package io.github.chriseteka.paystackclient.domain.product;

import io.github.chriseteka.paystackclient.domain.Amount;
import io.github.chriseteka.paystackclient.domain.Currency;
import io.github.chriseteka.paystackclient.domain.response.PaystackMultiResponse;
import io.github.chriseteka.paystackclient.domain.response.PaystackSingleResponse;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record ProductResponse(String name, String description, Currency currency, Amount.MoneyValue price,
                              Integer quantity, boolean is_shippable, boolean unlimited, BigInteger integration,
                              String domain, Object metadata, String slug, String product_code, Integer quantity_sold,
                              String type, Object shipping_fields, boolean active, boolean in_stock,
                              Integer minimum_orderable, Integer maximum_orderable, boolean low_stock_alert,
                              BigInteger id, ZonedDateTime createdAt, ZonedDateTime updatedAt) {

    public Amount getPrice() {
        return this.price.ofCurrency(this.currency);
    }

    public record Single(boolean status, String message, ProductResponse data)
            implements PaystackSingleResponse<ProductResponse> {
    }

    public record Multiple(boolean status, String message, List<ProductResponse> data, PageInfo.PageMetaInfo meta)
            implements PaystackMultiResponse<ProductResponse> {
    }

}
