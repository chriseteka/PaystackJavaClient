package io.github.chriseteka.paystackclient.domain.transaction;

import io.github.chriseteka.paystackclient.domain.response.PaystackSingleResponse;

public record ExportTransactionResponse(String path) {

    public record Single(boolean status, String message, ExportTransactionResponse data)
            implements PaystackSingleResponse<ExportTransactionResponse> {}
}
