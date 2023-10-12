package com.chrisworks.paystackclient.domain.appleplay;

import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;
import com.chrisworks.paystackclient.domain.response.ResponseDataDefaults;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record ApplePlayResponse(List<String> domainNames) implements ResponseDataDefaults {
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

    public record Single(boolean status, String message) implements PaystackSingleResponse<ApplePlayResponse> {
        @Override
        public ApplePlayResponse data() {
            return null;
        }
    }

    public record Multiple(boolean status, String message, ApplePlayResponse data)
            implements PaystackSingleResponse<ApplePlayResponse> {}
}
