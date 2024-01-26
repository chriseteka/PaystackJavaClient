package io.github.chriseteka.paystackclient.domain.transaction;

import io.github.chriseteka.paystackclient.domain.Amount;
import io.github.chriseteka.paystackclient.domain.Currency;
import io.github.chriseteka.paystackclient.domain.Email;
import io.github.chriseteka.paystackclient.domain.request.RequestBody;

import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

public final class ChargeAuthorizationRequest implements RequestBody<ChargeAuthorizationRequest> {

    private final String amount;
    private final String email;
    private final String authorization_code;
    private String reference;
    private String currency;
    private Map<String, Object> metadata;
    private Set<String> channels;
    private String subaccount;
    private BigInteger transaction_charge;
    private ChargeBearer bearer;
    private boolean queue;


    public ChargeAuthorizationRequest(Amount amount, Email email, String authorizationCode) {
        this.email = email.value();
        this.amount = amount.getUnitValue();
        this.authorization_code = authorizationCode;
    }

    public ChargeAuthorizationRequest currency(Currency currency) {
        this.currency = currency.name();
        return this;
    }

    public ChargeAuthorizationRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    public ChargeAuthorizationRequest metadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }

    public ChargeAuthorizationRequest channels(Set<String> channels) {
        this.channels = channels;
        return this;
    }

    public ChargeAuthorizationRequest subAccount(String subAccount) {
        this.subaccount = subAccount;
        return this;
    }

    public ChargeAuthorizationRequest transactionCharge(Amount transactionCharge) {
        this.transaction_charge = new BigInteger(transactionCharge.getUnitValue());
        return this;
    }

    public ChargeAuthorizationRequest bearer(ChargeBearer bearer) {
        this.bearer = bearer;
        return this;
    }

    public ChargeAuthorizationRequest queue(boolean queue) {
        this.queue = queue;
        return this;
    }
}
