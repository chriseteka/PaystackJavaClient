package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

public record InitTransactionResponse(String authorization_url, String access_code, String reference) {

    public record Single(boolean status, String message, InitTransactionResponse data)
            implements PaystackSingleResponse<InitTransactionResponse> {}
}
