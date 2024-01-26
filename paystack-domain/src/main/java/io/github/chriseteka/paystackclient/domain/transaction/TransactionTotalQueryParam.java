package io.github.chriseteka.paystackclient.domain.transaction;

import io.github.chriseteka.paystackclient.domain.request.PaystackListPagedQueryParam;
import io.github.chriseteka.paystackclient.domain.request.QueryParamConstants;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class TransactionTotalQueryParam extends PaystackListPagedQueryParam {

    public TransactionTotalQueryParam(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public TransactionTotalQueryParam() {
        super();
    }

    public TransactionTotalQueryParam from(ZonedDateTime from) {
        params.put(QueryParamConstants.FROM, from.toString());
        return this;
    }

    public TransactionTotalQueryParam to(ZonedDateTime to) {
        params.put(QueryParamConstants.TO, to.toString());
        return this;
    }
}
