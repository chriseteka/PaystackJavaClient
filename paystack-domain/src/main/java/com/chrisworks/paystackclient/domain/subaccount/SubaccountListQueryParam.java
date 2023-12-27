package com.chrisworks.paystackclient.domain.subaccount;

import com.chrisworks.paystackclient.domain.request.PaystackListPagedQueryParam;
import com.chrisworks.paystackclient.domain.request.QueryParamConstants;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public final class SubaccountListQueryParam extends PaystackListPagedQueryParam {

    public SubaccountListQueryParam(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public SubaccountListQueryParam(){
        super();
    }

    public SubaccountListQueryParam from(ZonedDateTime from){
        params.put(QueryParamConstants.FROM, from.toString());
        return this;
    }

    public SubaccountListQueryParam to(ZonedDateTime to){
        params.put(QueryParamConstants.TO, to.toString());
        return this;
    }
}
