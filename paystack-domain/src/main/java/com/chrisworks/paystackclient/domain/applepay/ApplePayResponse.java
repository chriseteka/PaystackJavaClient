package com.chrisworks.paystackclient.domain.applepay;

import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

import java.util.List;

public record ApplePayResponse(List<String> domainNames) {

    public record Multiple(boolean status, String message, ApplePayResponse data)
            implements PaystackSingleResponse<ApplePayResponse> {}
}
