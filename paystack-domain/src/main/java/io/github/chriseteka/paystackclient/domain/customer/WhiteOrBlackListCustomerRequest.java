package io.github.chriseteka.paystackclient.domain.customer;

import io.github.chriseteka.paystackclient.domain.Email;
import io.github.chriseteka.paystackclient.domain.request.RequestBody;

public final class WhiteOrBlackListCustomerRequest implements RequestBody<WhiteOrBlackListCustomerRequest> {
    private final String customer;
    private String risk_action;

    public WhiteOrBlackListCustomerRequest(String customerCode) {
        this.customer = customerCode;
    }

    public WhiteOrBlackListCustomerRequest(Email customerEmail) {
        this.customer = customerEmail.value();
    }

    public WhiteOrBlackListCustomerRequest riskAction(RiskAction riskAction) {
        this.risk_action = riskAction.value;
        return this;
    }

    public enum RiskAction {
        WHITELIST("allow"),
        BLACKLIST("deny"),
        DEFAULT("default");

        private final String value;

        RiskAction(String value) {
            this.value = value;
        }
    }
}
