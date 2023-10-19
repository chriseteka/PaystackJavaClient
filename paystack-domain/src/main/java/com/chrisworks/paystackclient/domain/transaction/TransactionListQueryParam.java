package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.request.PaystackListPagedQueryParam;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public final class TransactionListQueryParam extends PaystackListPagedQueryParam {

    public TransactionListQueryParam(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public TransactionListQueryParam() {
        super();
    }

    public TransactionListQueryParam customer(BigInteger customerId) {
        params.put("customer", String.valueOf(customerId));
        return this;
    }

    public TransactionListQueryParam terminalId(String terminalId) {
        params.put("terminalid", terminalId);
        return this;
    }

    public TransactionListQueryParam status(String status) {
        params.put("status", status);
        return this;
    }

    public TransactionListQueryParam from(ZonedDateTime from) {
        params.put("from", from.toString());
        return this;
    }

    public TransactionListQueryParam to(ZonedDateTime to) {
        params.put("to", to.toString());
        return this;
    }

    public TransactionListQueryParam amount(Amount amount) {
        params.put("amount", amount.getUnitValue());
        return this;
    }
}
