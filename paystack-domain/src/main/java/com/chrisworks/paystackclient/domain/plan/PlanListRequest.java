package com.chrisworks.paystackclient.domain.plan;

import com.chrisworks.paystackclient.domain.request.PaystackListPagedRequest;

import java.math.BigInteger;

public final class PlanListRequest extends PaystackListPagedRequest {

    private String status;
    private String interval;
    private String amount;

    public PlanListRequest(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
