package com.chrisworks.paystackclient.domain.subaccount;

import com.chrisworks.paystackclient.domain.request.RequestBody;

import java.util.List;
import java.util.Map;

public class CreateSubAccountRequest implements RequestBody<CreateSubAccountRequest> {
    private final String business_name;
    private final String settlement_bank;
    private final String account_number;
    private final Double percentage_charge;
    private final String description;
    private String primary_contact_email;
    private String primary_contact_name;
    private String primary_contact_phone;
    private String metadata;

    public CreateSubAccountRequest(String businessName, String settlementBank, String accountNumber,
                                   Double percentageCharge, String description) {
        this.business_name = businessName;
        this.settlement_bank = settlementBank;
        this.account_number = accountNumber;
        this.percentage_charge = percentageCharge;
        this.description = description;
    }

    public String getBusinessName() {
        return business_name;
    }

    public String getSettlementBank() {
        return settlement_bank;
    }

    public String getAccountNumber() {
        return account_number;
    }

    public Double getPercentageCharge() {
        return percentage_charge;
    }

    public String getDescription() {
        return description;
    }

    public String getPrimaryContactEmail() {
        return primary_contact_email;
    }

    public String getPrimaryContactName() {
        return primary_contact_name;
    }

    public String getPrimaryContactPhone() {
        return primary_contact_phone;
    }

    public String getMetadata() {
        return metadata;
    }

    public CreateSubAccountRequest primaryContactEmail(String primaryContactEmail) {
        this.primary_contact_email = primaryContactEmail;
        return this;
    }

    public CreateSubAccountRequest primaryContactName(String primaryContactName) {
        this.primary_contact_name = primaryContactName;
        return this;
    }

    public CreateSubAccountRequest primaryContactPhone(String primaryContactPhone) {
        this.primary_contact_phone = primaryContactPhone;
        return this;
    }

    public CreateSubAccountRequest metadata(MetaData metadata) {
        this.metadata = metadata.json();
        return this;
    }

    public record MetaData(List<Map<String, Object>> custom_fields) implements RequestBody<MetaData> {
    }

}
