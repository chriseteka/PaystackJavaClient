package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

public record ExportTransactionResponse(String path) {

    public record Single(boolean status, String message, ExportTransactionResponse data)
            implements PaystackSingleResponse<ExportTransactionResponse> {}
}
