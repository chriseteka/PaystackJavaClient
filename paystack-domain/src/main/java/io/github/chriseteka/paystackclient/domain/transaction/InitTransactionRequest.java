package io.github.chriseteka.paystackclient.domain.transaction;

import io.github.chriseteka.paystackclient.domain.Amount;
import io.github.chriseteka.paystackclient.domain.Currency;
import io.github.chriseteka.paystackclient.domain.Email;
import io.github.chriseteka.paystackclient.domain.request.RequestBody;

import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

public final class InitTransactionRequest implements RequestBody<InitTransactionRequest> {

    private final String amount;
    private final String email;
    private String currency;
    private String reference;
    private String callback_url;
    private String plan;
    private BigInteger invoice_limit;
    private Map<String, Object> metadata;
    private Set<String> channels;
    private String split_code;
    private String subaccount;
    private BigInteger transaction_charge;
    private ChargeBearer bearer;


    public InitTransactionRequest(Amount amount, Email email) {
        this.email = email.value();
        this.amount = amount.getUnitValue();
    }

    public InitTransactionRequest currency(Currency currency) {
        this.currency = currency.name();
        return this;
    }

    public InitTransactionRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    public InitTransactionRequest callbackUrl(String callbackUrl) {
        this.callback_url = callbackUrl;
        return this;
    }

    public InitTransactionRequest plan(String plan) {
        this.plan = plan;
        return this;
    }

    public InitTransactionRequest invoiceLimit(BigInteger invoiceLimit) {
        this.invoice_limit = invoiceLimit;
        return this;
    }

    public InitTransactionRequest metadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }

    public InitTransactionRequest channels(Set<String> channels) {
        this.channels = channels;
        return this;
    }

    public InitTransactionRequest splitCode(String splitCode) {
        this.split_code = splitCode;
        return this;
    }

    public InitTransactionRequest subAccount(String subAccount) {
        this.subaccount = subAccount;
        return this;
    }

    public InitTransactionRequest transactionCharge(Amount transactionCharge) {
        this.transaction_charge = new BigInteger(transactionCharge.getUnitValue());
        return this;
    }

    public InitTransactionRequest bearer(ChargeBearer bearer) {
        this.bearer = bearer;
        return this;
    }
}
