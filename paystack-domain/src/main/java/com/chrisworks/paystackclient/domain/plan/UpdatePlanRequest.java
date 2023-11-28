package com.chrisworks.paystackclient.domain.plan;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Interval;

import java.math.BigInteger;

public final class UpdatePlanRequest extends CreatePlanRequest {

    private final String currency;
    private String description;
    private boolean send_invoices;
    private String send_sms;
    private BigInteger invoice_limit;

    public UpdatePlanRequest(String name, Interval interval, Amount amount) {
        super(name, interval, amount);
        this.currency = amount.getCurrency().name();
    }

    public UpdatePlanRequest description(String description) {
        this.description = description;
        return this;
    }

    public UpdatePlanRequest sendInvoices(boolean sendInvoices) {
        this.send_invoices = sendInvoices;
        return this;
    }

    public UpdatePlanRequest sendSms(String sendSms) {
        this.send_sms = sendSms;
        return this;
    }

    public UpdatePlanRequest invoiceLimit(BigInteger invoiceLimit) {
        this.invoice_limit = invoiceLimit;
        return this;
    }
}
