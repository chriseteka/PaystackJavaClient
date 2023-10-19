package com.chrisworks.paystackclient.domain.transaction;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Email;
import com.chrisworks.paystackclient.domain.request.RequestBody;

public final class PartialDebitRequest implements RequestBody<PartialDebitRequest> {

    private final String authorization_code;
    private final String currency;
    private final String amount;
    private final String email;
    private String reference;
    private String at_least;

    public PartialDebitRequest(String authorizationCode, Amount amount, Email email) {
        this.email = email.value();
        this.amount = amount.getUnitValue();
        this.currency = amount.getCurrency().name();
        this.authorization_code = authorizationCode;
    }

    public PartialDebitRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    public PartialDebitRequest atLeast(String atLeast) {
        this.at_least = atLeast;
        return this;
    }
}
