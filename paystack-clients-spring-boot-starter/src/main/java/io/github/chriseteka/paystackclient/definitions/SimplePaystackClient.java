package io.github.chriseteka.paystackclient.definitions;

import io.github.chriseteka.paystackclient.conditions.NoClientIsSelectedToBeActive;
import io.github.chriseteka.paystackclient.definitions.simple.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

public interface SimplePaystackClient {

    ApplePayClient applePay();
    CustomerClient customer();
    PlanClient plan();
    ProductClient product();
    SubAccountClient subAccount();
    TransactionClient transaction();

    @Component(value = "simplePaystackClient")
    @Conditional(NoClientIsSelectedToBeActive.class)
    @ConditionalOnProperty(prefix = "paystack-client", name = "definition-type", havingValue = "NON_REACTIVE", matchIfMissing = true)
    record Impl(ApplePayClient applePay, CustomerClient customer, PlanClient plan, ProductClient product,
                SubAccountClient subAccount, TransactionClient transaction) implements SimplePaystackClient {}
}
