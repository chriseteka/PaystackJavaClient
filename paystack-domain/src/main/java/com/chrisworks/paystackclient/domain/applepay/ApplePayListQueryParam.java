package com.chrisworks.paystackclient.domain.applepay;

import com.chrisworks.paystackclient.domain.request.PaystackListUnPagedQueryParam;

public class ApplePayListQueryParam extends PaystackListUnPagedQueryParam {

    public ApplePayListQueryParam(boolean useCursor) {
        super(useCursor);
    }

    public ApplePayListQueryParam next(String next) {
        params.put("next", next);
        return this;
    }

    public ApplePayListQueryParam previous(String previous) {
        params.put("previous", previous);
        return this;
    }
}
