package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Currency;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

import java.math.BigInteger;
import java.util.List;

public record TransactionTotalResponse(BigInteger total_transactions, BigInteger unique_customers,
                                       Amount.MoneyValue total_volume, List<VolumeByCurrency> total_volume_by_currency,
                                       Amount.MoneyValue pending_transfers, List<VolumeByCurrency> pending_transfers_by_currency) {

    public record VolumeByCurrency(Currency currency, Amount.MoneyValue amount) {
        public Amount asAmount() {
            return amount.ofCurrency(currency);
        }
    }

    public record Single(boolean status, String message, TransactionTotalResponse data)
            implements PaystackSingleResponse<TransactionTotalResponse> {}
}
