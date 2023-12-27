package com.chrisworks.paystackclient;

import com.chrisworks.paystackclient.definitions.DefinitionType;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("paystack-client")
public class PaystackClientsProperties {

    private String secretKey;
    private DefinitionType definitionType = DefinitionType.NON_REACTIVE;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public DefinitionType getDefinitionType() {
        return definitionType;
    }

    public void setDefinitionType(DefinitionType definitionType) {
        this.definitionType = definitionType;
    }
}
