package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Currency;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;
import com.chrisworks.paystackclient.domain.response.ResponseDataDefaults;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record TransactionTotalResponse(BigInteger total_transactions, BigInteger unique_customers,
                                       Amount.MoneyValue total_volume, List<VolumeByCurrency> total_volume_by_currency,
                                       Amount.MoneyValue pending_transfers, List<VolumeByCurrency> pending_transfers_by_currency)
        implements ResponseDataDefaults {

    public record VolumeByCurrency(Currency currency, Amount.MoneyValue amount) {
        public Amount asAmount() {
            return amount.ofCurrency(currency);
        }
    }

    @Override
    public BigInteger id() {
        return null;
    }

    @Override
    public String domain() {
        return null;
    }

    @Override
    public ZonedDateTime createdAt() {
        return null;
    }

    @Override
    public ZonedDateTime updatedAt() {
        return null;
    }

    public record Single(boolean status, String message, TransactionTotalResponse data)
            implements PaystackSingleResponse<TransactionTotalResponse> {}
}
