package io.github.chriseteka.paystackclient.domain.applepay;

import io.github.chriseteka.paystackclient.domain.PaystackException;
import io.github.chriseteka.paystackclient.domain.request.RequestBody;

import java.net.MalformedURLException;
import java.net.URI;

public record ApplePayRequest(String domainName) implements RequestBody<ApplePayRequest> {

    //TODO: Let's follow this style to add little validation's here and there to request objects
    public ApplePayRequest {
        try {
            //Validation to ensure a valid domain name was passed
            URI.create(domainName).toURL();
        } catch (MalformedURLException e) {
            throw new PaystackException(e);
        }
    }
}
