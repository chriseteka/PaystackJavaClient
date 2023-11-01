package com.chrisworks.paystackclient.domain.applepay;

import com.chrisworks.paystackclient.domain.request.PaystackListUnPagedQueryParam;
import com.chrisworks.paystackclient.domain.request.QueryParamConstants;

public class ApplePayListQueryParam extends PaystackListUnPagedQueryParam {

    public ApplePayListQueryParam(boolean useCursor) {
        super(useCursor);
    }

    public ApplePayListQueryParam next(String next) {
        params.put(QueryParamConstants.NEXT, next);
        return this;
    }

    public ApplePayListQueryParam previous(String previous) {
        params.put(QueryParamConstants.PREVIOUS, previous);
        return this;
    }
}
