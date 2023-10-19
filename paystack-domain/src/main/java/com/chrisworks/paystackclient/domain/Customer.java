package com.chrisworks.paystackclient.domain;

import java.math.BigInteger;

public record Customer(BigInteger id, String first_name, String last_name, String email, String customer_code,
                       String phone, Object metadata, String risk_action, String international_format_phone)  {
}
