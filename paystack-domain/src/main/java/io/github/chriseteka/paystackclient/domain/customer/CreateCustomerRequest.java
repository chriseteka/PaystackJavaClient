package io.github.chriseteka.paystackclient.domain.customer;

import io.github.chriseteka.paystackclient.domain.Email;
import io.github.chriseteka.paystackclient.domain.request.RequestBody;

import java.util.Map;

//Although paystack doc says, firstName, lastName and phone are optional in some cases, but not in other cases,
// we've enforced it to be compulsory
public final class CreateCustomerRequest implements RequestBody<CreateCustomerRequest> {
    private final String email;
    private final String first_name;
    private final String last_name;
    private final String phone;
    private Map<String, Object> metadata;

    public CreateCustomerRequest(Email email, String firstName, String lastName, String phone) {
        this.email = email.value();
        this.first_name = firstName;
        this.last_name = lastName;
        this.phone = phone;
    }

    public CreateCustomerRequest metadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
