package io.github.chriseteka.paystackclient.domain.subaccount;

import io.github.chriseteka.paystackclient.domain.response.PaystackMultiResponse;
import io.github.chriseteka.paystackclient.domain.response.PaystackSingleResponse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

public record SubAccountResponse(BigInteger integration, String domain, String subaccount_code, String business_name,
                                 String description, String primary_contact_name, String primary_contact_email,
                                 String primary_contact_phone, Object metadata, BigDecimal percentage_charge,
                                 boolean is_verified, String settlement_bank, String account_number,
                                 String settlement_schedule, boolean active, boolean migrate, BigInteger id,
                                 ZonedDateTime createdAt, ZonedDateTime updatedAt) {

    public record Single(boolean status, String message, SubAccountResponse data)
            implements PaystackSingleResponse<SubAccountResponse> {
    }

    public record Multiple(boolean status, String message, List<SubAccountResponse> data, PageInfo.PageMetaInfo meta)
            implements PaystackMultiResponse<SubAccountResponse> {

    }
}
