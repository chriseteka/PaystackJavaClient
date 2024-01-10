package com.chrisworks.paystackclient.domain.subaccount;

import com.chrisworks.paystackclient.domain.request.PaystackListPagedQueryParam;
import com.chrisworks.paystackclient.domain.request.QueryParamConstants;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public final class SubAccountListQueryParam extends PaystackListPagedQueryParam {

    public SubAccountListQueryParam(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public SubAccountListQueryParam(){
        super();
    }

    public SubAccountListQueryParam from(ZonedDateTime from){
        params.put(QueryParamConstants.FROM, from.toString());
        return this;
    }

    public SubAccountListQueryParam to(ZonedDateTime to){
        params.put(QueryParamConstants.TO, to.toString());
        return this;
    }
}
