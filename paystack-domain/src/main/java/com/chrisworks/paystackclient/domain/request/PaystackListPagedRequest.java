package com.chrisworks.paystackclient.domain.request;

import java.math.BigInteger;

public abstract class PaystackListPagedRequest {
    protected final BigInteger perPage;
    protected final BigInteger page;

    protected PaystackListPagedRequest(BigInteger perPage, BigInteger page) {
        this.perPage = perPage;
        this.page = page;
    }
}
