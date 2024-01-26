package io.github.chriseteka.paystackclient.domain.applepay;

import io.github.chriseteka.paystackclient.domain.request.PaystackListUnPagedQueryParam;
import io.github.chriseteka.paystackclient.domain.request.QueryParamConstants;

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
