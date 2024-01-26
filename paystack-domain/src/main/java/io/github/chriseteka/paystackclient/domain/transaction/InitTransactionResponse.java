package io.github.chriseteka.paystackclient.domain.transaction;

import io.github.chriseteka.paystackclient.domain.response.PaystackSingleResponse;

public record InitTransactionResponse(String authorization_url, String access_code, String reference) {

    public record Single(boolean status, String message, InitTransactionResponse data)
            implements PaystackSingleResponse<InitTransactionResponse> {}
}
