package io.github.chriseteka.paystackclient.domain.customer;

import io.github.chriseteka.paystackclient.domain.request.RequestBody;

public record DeactivateAuthorizationRequest(String authorization_code)
        implements RequestBody<DeactivateAuthorizationRequest> {}
