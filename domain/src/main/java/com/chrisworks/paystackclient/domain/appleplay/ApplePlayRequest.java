package com.chrisworks.paystackclient.domain.appleplay;

import com.chrisworks.paystackclient.domain.request.RequestBody;

public record ApplePlayRequest(String domainName) implements RequestBody<ApplePlayRequest> {}
