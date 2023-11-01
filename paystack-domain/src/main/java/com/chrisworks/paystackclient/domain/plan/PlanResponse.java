package com.chrisworks.paystackclient.domain.plan;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Currency;
import com.chrisworks.paystackclient.domain.Interval;
import com.chrisworks.paystackclient.domain.response.PaystackMultiResponse;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record PlanResponse(String name, Amount.MoneyValue amount, Interval interval, BigInteger integration,
                           String domain, String plan_code, boolean send_invoices, boolean send_sms, boolean hosted_page,
                           Currency currency, BigInteger id, ZonedDateTime createdAt, ZonedDateTime updatedAt) {

    public Amount getAmount() {
        return this.amount.ofCurrency(this.currency);
    }

    public record Single(boolean status, String message, PlanResponse data)
            implements PaystackSingleResponse<PlanResponse> {}
    public record Multiple(boolean status, String message, List<PlanResponse> data, PageMetaInfo.Impl meta)
            implements PaystackMultiResponse<PlanResponse> {}
}
