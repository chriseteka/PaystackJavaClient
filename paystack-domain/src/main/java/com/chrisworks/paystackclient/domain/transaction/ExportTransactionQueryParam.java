package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Currency;
import com.chrisworks.paystackclient.domain.request.PaystackListPagedQueryParam;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public final class ExportTransactionQueryParam extends PaystackListPagedQueryParam {

    public ExportTransactionQueryParam(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public ExportTransactionQueryParam() {
        super();
    }

    public ExportTransactionQueryParam from(ZonedDateTime from) {
        params.put("from", from.toString());
        return this;
    }

    public ExportTransactionQueryParam to(ZonedDateTime to) {
        params.put("to", to.toString());
        return this;
    }

    public ExportTransactionQueryParam customer(BigInteger customerId) {
        params.put("customer", String.valueOf(customerId));
        return this;
    }

    public ExportTransactionQueryParam status(String status) {
        params.put("status", status);
        return this;
    }

    public ExportTransactionQueryParam currency(Currency currency) {
        params.put("currency", currency.name());
        return this;
    }

    public ExportTransactionQueryParam amount(Amount amount) {
        params.put("amount", amount.getUnitValue());
        return this;
    }

    public ExportTransactionQueryParam settled(boolean settled) {
        params.put("settled", Boolean.toString(settled));
        return this;
    }

    public ExportTransactionQueryParam settlement(BigInteger settlement) {
        params.put("settlement", String.valueOf(settlement));
        return this;
    }

    public ExportTransactionQueryParam paymentPage(BigInteger paymentPage) {
        params.put("payment_page", String.valueOf(paymentPage));
        return this;
    }

}
