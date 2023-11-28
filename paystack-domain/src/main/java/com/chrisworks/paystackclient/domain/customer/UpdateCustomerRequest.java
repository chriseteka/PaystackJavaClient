package com.chrisworks.paystackclient.domain.customer;

import com.chrisworks.paystackclient.domain.request.RequestBody;

import java.util.Map;

//Although paystack doc says, firstName, lastName and phone are optional in some cases, but not in other cases,
// we've enforced it to be compulsory
public final class UpdateCustomerRequest implements RequestBody<UpdateCustomerRequest> {
    private final String first_name;
    private final String last_name;
    private final String phone;
    private Map<String, Object> metadata;

    public UpdateCustomerRequest(String firstName, String lastName, String phone) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.phone = phone;
    }

    public UpdateCustomerRequest metadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
