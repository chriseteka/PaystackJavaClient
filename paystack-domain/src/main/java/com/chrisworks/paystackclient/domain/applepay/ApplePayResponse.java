package com.chrisworks.paystackclient.domain.applepay;

import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;
import com.chrisworks.paystackclient.domain.response.ResponseDataDefaults;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record ApplePayResponse(List<String> domainNames) implements ResponseDataDefaults {
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

    public record Single(boolean status, String message) implements PaystackSingleResponse<ApplePayResponse> {
        @Override
        public ApplePayResponse data() {
            return null;
        }
    }

    public record Multiple(boolean status, String message, ApplePayResponse data)
            implements PaystackSingleResponse<ApplePayResponse> {}
}
