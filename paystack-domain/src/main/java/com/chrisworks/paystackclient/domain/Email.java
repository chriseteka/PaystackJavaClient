package com.chrisworks.paystackclient.domain;

public record Email(String value) {

    public Email {
        //If it is not compliant to the form we want, throw err
    }
}
