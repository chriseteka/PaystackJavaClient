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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSend_invoices(boolean send_invoices) {
        this.send_invoices = send_invoices;
    }

    public void setSend_sms(String send_sms) {
        this.send_sms = send_sms;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setInvoice_limit(BigInteger invoice_limit) {
        this.invoice_limit = invoice_limit;
    }
}
