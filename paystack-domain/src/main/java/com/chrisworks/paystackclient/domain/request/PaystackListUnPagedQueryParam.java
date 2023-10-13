package com.chrisworks.paystackclient.domain.request;

import java.util.HashMap;
import java.util.Map;

public class PaystackListUnPagedQueryParam implements QueryParamBuilder {

    protected final Map<String, String> params = new HashMap<>(15);

    public PaystackListUnPagedQueryParam(boolean useCursor) {
        params.put("use_cursor", Boolean.toString(useCursor));
    }

    @Override
    public final Map<String, String> params() {
        return params;
    }
}
