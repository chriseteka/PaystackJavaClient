package io.github.chriseteka.paystackclient.domain.customer;

import io.github.chriseteka.paystackclient.domain.request.RequestBody;

public final class ValidateCustomerRequest implements RequestBody<ValidateCustomerRequest> {
    private final String country;
    private final String type;
    private final String account_number;
    private final String bvn;
    private final String bank_code;
    private final String first_name;
    private final String last_name;
    private String middle_name;

    public ValidateCustomerRequest(IssuerCountry country, String type, String accountNumber, String bvn, String bankCode,
                                   String firstName, String lastName) {
        this.country = country.name();
        this.type = type;
        this.account_number = accountNumber;
        this.bvn = bvn;
        this.bank_code = bankCode;
        this.first_name = firstName;
        this.last_name = lastName;
    }

    public ValidateCustomerRequest middleName(String middleName) {
        this.middle_name = middleName;
        return this;
    }

    public enum IssuerCountry {
        NG
    }
}
