package io.github.chriseteka.paystackclient.domain.plan;

import io.github.chriseteka.paystackclient.domain.Amount;
import io.github.chriseteka.paystackclient.domain.Interval;
import io.github.chriseteka.paystackclient.domain.request.PaystackListPagedQueryParam;
import io.github.chriseteka.paystackclient.domain.request.QueryParamConstants;

import java.math.BigInteger;

public final class PlanListQueryParam extends PaystackListPagedQueryParam {

    public PlanListQueryParam(BigInteger perPage, BigInteger page) {
        super(perPage, page);
    }

    public PlanListQueryParam() {
        super();
    }

    public PlanListQueryParam status(String status) {
        params.put(QueryParamConstants.STATUS, status);
        return this;
    }

    public PlanListQueryParam interval(Interval interval) {
        params.put(QueryParamConstants.INTERVAL, interval.name().toLowerCase());
        return this;
    }

    public PlanListQueryParam amount(Amount amount) {
        params.put(QueryParamConstants.AMOUNT, amount.getUnitValue());
        return this;
    }

}
