package com.chrisworks.paystackclients;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("paystack-client")
public class PaystackClientsProperties {

    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
