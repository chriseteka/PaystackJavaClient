package com.chrisworks.paystackclient.domain.customer;

import com.chrisworks.paystackclient.domain.response.PaystackMultiResponse;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record CustomerResponse(BigInteger id, String first_name, String last_name, String email, String customer_code,
                               String phone, Object metadata, String risk_action, String international_format_phone,
                               String domain, BigInteger integration, ZonedDateTime createdAt, ZonedDateTime updatedAt,
                               boolean identified, Object identifications)  {

    public record Single(boolean status, String message, CustomerResponse data)
            implements PaystackSingleResponse<CustomerResponse> {}

    public record Multiple(boolean status, String message, List<CustomerResponse> data, PageInfo.PageMetaInfo meta)
            implements PaystackMultiResponse<CustomerResponse> {}
}
