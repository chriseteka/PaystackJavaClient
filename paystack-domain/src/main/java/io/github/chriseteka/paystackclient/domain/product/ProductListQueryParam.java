package io.github.chriseteka.paystackclient.domain.product;

import io.github.chriseteka.paystackclient.domain.request.PaystackListPagedQueryParam;
import io.github.chriseteka.paystackclient.domain.request.QueryParamConstants;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public final class ProductListQueryParam extends PaystackListPagedQueryParam {

    public ProductListQueryParam(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public ProductListQueryParam(){
        super();
    }

    public ProductListQueryParam from(ZonedDateTime from){
        params.put(QueryParamConstants.FROM, from.toString());
        return this;
    }

    public ProductListQueryParam to(ZonedDateTime to){
        params.put(QueryParamConstants.TO, to.toString());
        return this;
    }
}
