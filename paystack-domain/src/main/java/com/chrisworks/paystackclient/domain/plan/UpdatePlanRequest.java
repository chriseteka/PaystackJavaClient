package com.chrisworks.paystackclient.domain.plan;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Interval;

import java.math.BigInteger;

public final class UpdatePlanRequest extends CreatePlanRequest {

    private String description;
    private boolean send_invoices;
    private String send_sms;
    private String currency;
    private BigInteger invoice_limit;

    public UpdatePlanRequest(String name, Interval interval, Amount amount) {
        super(name, interval, amount);
    }

    public UpdatePlanRequest description(String description) {
        this.description = description;
        return this;
    }

    public UpdatePlanRequest send_invoices(boolean send_invoices) {
        this.send_invoices = send_invoices;
        return this;
    }

    public UpdatePlanRequest send_sms(String send_sms) {
        this.send_sms = send_sms;
        return this;
    }

    public UpdatePlanRequest currency(String currency) {
        this.currency = currency;
        return this;
    }

    public UpdatePlanRequest invoice_limit(BigInteger invoice_limit) {
        this.invoice_limit = invoice_limit;
        return this;
    }
}
