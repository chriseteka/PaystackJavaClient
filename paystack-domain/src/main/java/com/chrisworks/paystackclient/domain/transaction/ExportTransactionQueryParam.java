package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Currency;
import com.chrisworks.paystackclient.domain.request.PaystackListPagedQueryParam;
import com.chrisworks.paystackclient.domain.request.QueryParamConstants;

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
        params.put(QueryParamConstants.FROM, from.toString());
        return this;
    }

    public ExportTransactionQueryParam to(ZonedDateTime to) {
        params.put(QueryParamConstants.TO, to.toString());
        return this;
    }

    public ExportTransactionQueryParam customer(BigInteger customerId) {
        params.put(QueryParamConstants.CUSTOMER, String.valueOf(customerId));
        return this;
    }

    public ExportTransactionQueryParam status(String status) {
        params.put(QueryParamConstants.STATUS, status);
        return this;
    }

    public ExportTransactionQueryParam currency(Currency currency) {
        params.put(QueryParamConstants.CURRENCY, currency.name());
        return this;
    }

    public ExportTransactionQueryParam amount(Amount amount) {
        params.put(QueryParamConstants.AMOUNT, amount.getUnitValue());
        return this;
    }

    public ExportTransactionQueryParam settled(boolean settled) {
        params.put(QueryParamConstants.SETTLED, Boolean.toString(settled));
        return this;
    }

    public ExportTransactionQueryParam settlement(BigInteger settlement) {
        params.put(QueryParamConstants.SETTLEMENT, String.valueOf(settlement));
        return this;
    }

    public ExportTransactionQueryParam paymentPage(BigInteger paymentPage) {
        params.put(QueryParamConstants.PAYMENT_PAGE, String.valueOf(paymentPage));
        return this;
    }

}
