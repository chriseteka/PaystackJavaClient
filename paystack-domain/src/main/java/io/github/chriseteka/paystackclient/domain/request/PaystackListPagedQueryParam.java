package io.github.chriseteka.paystackclient.domain.request;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public abstract class PaystackListPagedQueryParam implements QueryParamBuilder {
    protected final Map<String, String> params = new HashMap<>(15);

    protected PaystackListPagedQueryParam(BigInteger perPage, BigInteger page) {
        params.put(QueryParamConstants.PAGE, page.toString());
        params.put(QueryParamConstants.PER_PAGE, perPage.toString());
    }

    protected PaystackListPagedQueryParam() {}

    @Override
    public final Map<String, String> params() {
        return params;
    }

    public static final class Empty extends PaystackListPagedQueryParam {}
}
