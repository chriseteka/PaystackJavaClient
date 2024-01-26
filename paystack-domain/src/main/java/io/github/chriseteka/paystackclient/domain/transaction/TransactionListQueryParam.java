package io.github.chriseteka.paystackclient.domain.transaction;

import io.github.chriseteka.paystackclient.domain.Amount;
import io.github.chriseteka.paystackclient.domain.request.PaystackListPagedQueryParam;
import io.github.chriseteka.paystackclient.domain.request.QueryParamConstants;

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
        params.put(QueryParamConstants.CUSTOMER, String.valueOf(customerId));
        return this;
    }

    public TransactionListQueryParam terminalId(String terminalId) {
        params.put(QueryParamConstants.TERMINAL_ID, terminalId);
        return this;
    }

    public TransactionListQueryParam status(String status) {
        params.put(QueryParamConstants.STATUS, status);
        return this;
    }

    public TransactionListQueryParam from(ZonedDateTime from) {
        params.put(QueryParamConstants.FROM, from.toString());
        return this;
    }

    public TransactionListQueryParam to(ZonedDateTime to) {
        params.put(QueryParamConstants.TO, to.toString());
        return this;
    }

    public TransactionListQueryParam amount(Amount amount) {
        params.put(QueryParamConstants.AMOUNT, amount.getUnitValue());
        return this;
    }
}
