package com.chrisworks.paystackclient.domain.customer;

import com.chrisworks.paystackclient.domain.request.PaystackListPagedQueryParam;
import com.chrisworks.paystackclient.domain.request.QueryParamConstants;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class CustomerListQueryParam extends PaystackListPagedQueryParam {

    public CustomerListQueryParam(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public CustomerListQueryParam() {
        super();
    }

    public CustomerListQueryParam from(ZonedDateTime from) {
        params.put(QueryParamConstants.FROM, from.toString());
        return this;
    }

    public CustomerListQueryParam to(ZonedDateTime to) {
        params.put(QueryParamConstants.TO, to.toString());
        return this;
    }
}
