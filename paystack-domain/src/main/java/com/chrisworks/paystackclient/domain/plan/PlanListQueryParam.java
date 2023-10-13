package com.chrisworks.paystackclient.domain.plan;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Interval;
import com.chrisworks.paystackclient.domain.request.PaystackListPagedQueryParam;

import java.math.BigInteger;

public final class PlanListQueryParam extends PaystackListPagedQueryParam {

    public PlanListQueryParam(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public PlanListQueryParam() {
        super();
    }

    public PlanListQueryParam status(String status) {
        params.put("status", status);
        return this;
    }

    public PlanListQueryParam interval(Interval interval) {
        params.put("interval", interval.name().toLowerCase());
        return this;
    }

    public PlanListQueryParam amount(Amount amount) {
        params.put("amount", amount.getUnitValue());
        return this;
    }

}
