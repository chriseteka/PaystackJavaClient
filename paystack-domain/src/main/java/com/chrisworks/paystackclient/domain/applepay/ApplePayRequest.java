package com.chrisworks.paystackclient.domain.applepay;

import com.chrisworks.paystackclient.domain.request.RequestBody;

public record ApplePayRequest(String domainName) implements RequestBody<ApplePayRequest> {}
