package com.chrisworks.paystackclient.domain.plan;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Interval;
import com.chrisworks.paystackclient.domain.request.RequestBody;

public class CreatePlanRequest implements RequestBody<CreatePlanRequest> {
    private final String name;
    private final String interval;
    private final String amount;

    public CreatePlanRequest(String name, Interval interval, Amount amount) {
        this.name = name;
        this.interval = interval.name().toLowerCase();
        this.amount = amount.getUnitValue();
    }
}
