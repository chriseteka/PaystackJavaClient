package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

import java.math.BigInteger;
import java.util.List;

public record TimeLineResponse(BigInteger time_spent, int attempts, Object authentication, int errors, boolean success,
                               boolean mobile, Object input, String channel, List<History> history)  {

    public record History(String type, String message, BigInteger time) {}

    public record Single(boolean status, String message, TimeLineResponse data)
            implements PaystackSingleResponse<TimeLineResponse> {}
}
