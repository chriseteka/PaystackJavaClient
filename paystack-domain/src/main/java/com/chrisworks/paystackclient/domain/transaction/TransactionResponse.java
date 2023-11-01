package com.chrisworks.paystackclient.domain.transaction;


import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Authorization;
import com.chrisworks.paystackclient.domain.Currency;
import com.chrisworks.paystackclient.domain.Customer;
import com.chrisworks.paystackclient.domain.response.PaystackMultiResponse;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record TransactionResponse(BigInteger id, String domain, String status, String reference, Amount.MoneyValue amount,
                                  String message, String gateway_response, ZonedDateTime paid_at, ZonedDateTime created_at,
                                  String channel, Currency currency, String ip_address, Object metadata, TimeLineResponse log,
                                  Amount.MoneyValue fees, Object fees_split, Authorization authorization, Customer customer,
                                  Object plan, Object split, BigInteger order_id, ZonedDateTime paidAt, ZonedDateTime createdAt,
                                  Amount.MoneyValue requested_amount, Object pos_transaction_data, Object source, Object fees_breakdown,
                                  ZonedDateTime transaction_date, Object plan_object, Object subaccount) {

    public record Single(boolean status, String message, TransactionResponse data)
            implements PaystackSingleResponse<TransactionResponse> {}

    public record Multiple(boolean status, String message, List<TransactionResponse> data, PageMetaInfo.Impl meta)
            implements PaystackMultiResponse<TransactionResponse> {}
}
