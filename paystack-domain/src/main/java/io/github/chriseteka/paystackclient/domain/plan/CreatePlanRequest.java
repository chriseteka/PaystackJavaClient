package io.github.chriseteka.paystackclient.domain.plan;

import io.github.chriseteka.paystackclient.domain.Amount;
import io.github.chriseteka.paystackclient.domain.Interval;
import io.github.chriseteka.paystackclient.domain.request.RequestBody;

public class CreatePlanRequest implements RequestBody<CreatePlanRequest> {
    private final String name;
    private final String interval;
    private final String amount;

    public CreatePlanRequest(String name, Interval interval, Amount amount) {
        this.name = name;
        this.interval = interval.name().toLowerCase();
        this.amount = amount.getUnitValue();
    }

    public String getName() {
        return name;
    }

    public String getInterval() {
        return interval;
    }

    public String getAmount() {
        return amount;
    }
}
