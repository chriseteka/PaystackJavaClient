package io.github.chriseteka.paystackclient.domain.customer;

import io.github.chriseteka.paystackclient.domain.Amount;
import io.github.chriseteka.paystackclient.domain.Authorization;
import io.github.chriseteka.paystackclient.domain.response.PaystackSingleResponse;
import io.github.chriseteka.paystackclient.domain.transaction.TransactionTotalResponse;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record DetailedCustomerResponse(BigInteger id, String first_name, String last_name, String email,
                                       String customer_code, String phone, Object metadata, String risk_action,
                                       String international_format_phone, String domain, BigInteger integration,
                                       ZonedDateTime createdAt, ZonedDateTime updatedAt, boolean identified,
                                       Object identifications, Amount.MoneyValue total_transactions,
                                       List<TransactionTotalResponse.VolumeByCurrency> total_transaction_value,
                                       Amount.MoneyValue dedicated_account, Object transactions, Object subscriptions,
                                       List<Authorization> authorizations) {

    public record Single(boolean status, String message, DetailedCustomerResponse data)
            implements PaystackSingleResponse<DetailedCustomerResponse> {}
}
