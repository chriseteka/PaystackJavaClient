package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;
import com.chrisworks.paystackclient.domain.response.ResponseDataDefaults;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public record InitTransactionResponse(String authorization_url, String access_code, String reference)
        implements ResponseDataDefaults {
    @Override
    public BigInteger id() {
        return null;
    }

    @Override
    public String domain() {
        return null;
    }

    @Override
    public ZonedDateTime createdAt() {
        return null;
    }

    @Override
    public ZonedDateTime updatedAt() {
        return null;
    }

    public record Single(boolean status, String message, InitTransactionResponse data)
            implements PaystackSingleResponse<InitTransactionResponse> {}
}
