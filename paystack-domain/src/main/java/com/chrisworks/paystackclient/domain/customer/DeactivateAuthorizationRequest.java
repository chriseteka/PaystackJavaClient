package com.chrisworks.paystackclient.domain.customer;

import com.chrisworks.paystackclient.domain.request.RequestBody;

public record DeactivateAuthorizationRequest(String authorization_code)
        implements RequestBody<DeactivateAuthorizationRequest> {}
