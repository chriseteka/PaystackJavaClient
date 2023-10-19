package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;
import com.chrisworks.paystackclient.domain.response.ResponseDataDefaults;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record TimeLineResponse(BigInteger time_spent,
                               int attempts,
                               Object authentication,
                               int errors,
                               boolean success,
                               boolean mobile,
                               Object input,
                               String channel,
                               List<History> history)
        implements ResponseDataDefaults {

    public record History(String type, String message, BigInteger time) {}


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

    public record Single(boolean status, String message, TimeLineResponse data)
            implements PaystackSingleResponse<TimeLineResponse> {}
}
