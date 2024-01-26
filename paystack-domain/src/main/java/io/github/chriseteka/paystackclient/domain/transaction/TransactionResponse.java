package io.github.chriseteka.paystackclient.domain.transaction;


import io.github.chriseteka.paystackclient.domain.Amount;
import io.github.chriseteka.paystackclient.domain.Authorization;
import io.github.chriseteka.paystackclient.domain.Currency;
import io.github.chriseteka.paystackclient.domain.customer.CustomerResponse;
import io.github.chriseteka.paystackclient.domain.response.PaystackMultiResponse;
import io.github.chriseteka.paystackclient.domain.response.PaystackSingleResponse;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record TransactionResponse(BigInteger id, String domain, String status, String reference, Amount.MoneyValue amount,
                                  String message, String gateway_response, ZonedDateTime paid_at, ZonedDateTime created_at,
                                  String channel, Currency currency, String ip_address, Object metadata, TimeLineResponse log,
                                  Amount.MoneyValue fees, Object fees_split, Authorization authorization, CustomerResponse customer,
                                  Object plan, Object split, BigInteger order_id, ZonedDateTime paidAt, ZonedDateTime createdAt,
                                  Amount.MoneyValue requested_amount, Object pos_transaction_data, Object source, Object fees_breakdown,
                                  ZonedDateTime transaction_date, Object plan_object, Object subaccount) {

    public record Single(boolean status, String message, TransactionResponse data)
            implements PaystackSingleResponse<TransactionResponse> {}

    public record Multiple(boolean status, String message, List<TransactionResponse> data, PageInfo.PageMetaInfo meta)
            implements PaystackMultiResponse<TransactionResponse> {}
}
