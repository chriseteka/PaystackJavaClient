package com.chrisworks.paystackclient.domain.subaccount;

import com.chrisworks.paystackclient.domain.Email;
import com.chrisworks.paystackclient.domain.response.PaystackMultiResponse;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record SubaccountResponse(BigInteger integration, String domain, String subaccount_code, String business_name,
                                 String description, String primary_contact_name, Email primary_contact_email,
                                 String primary_contact_phone, Object metadata, BigDecimal percentage_charge,
                                 boolean is_verified, String settlement_bank, String account_number,
                                 String settlement_schedule, boolean active, boolean migrate, BigInteger id,
                                 ZonedDateTime createdAt, ZonedDateTime updatedAt) {

    public record Single(boolean status, String message, SubaccountResponse data)
            implements PaystackSingleResponse<SubaccountResponse> {
    }

    public record Multiple(boolean status, String message, List<SubaccountResponse> data, PageInfo.PageMetaInfo meta)
            implements PaystackMultiResponse<SubaccountResponse> {

    }
}
