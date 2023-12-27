package com.chrisworks.paystackclient.domain.subaccount;

import com.chrisworks.paystackclient.domain.request.RequestBody;

import java.math.BigDecimal;

public class CreateSubaccountRequest implements RequestBody<CreateSubaccountRequest> {
    private final String business_name;
    private final String settlement_bank;
    private final String account_number;
    private final BigDecimal percentage_charge;
    private final String description;
    private String primary_contact_email;
    private String primary_contact_name;
    private String primary_contact_phone;
    private String metadata;

    public CreateSubaccountRequest(String businessName, String settlementBank, String accountNumber,
                                   BigDecimal percentageCharge, String description) {
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

    public BigDecimal getPercentageCharge() {
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

    public CreateSubaccountRequest primaryContactEmail(String primaryContactEmail) {
        this.primary_contact_email = primaryContactEmail;
        return this;
    }

    public CreateSubaccountRequest primaryContactName(String primaryContactName) {
        this.primary_contact_name = primaryContactName;
        return this;
    }

    public CreateSubaccountRequest primaryContactPhone(String primaryContactPhone) {
        this.primary_contact_phone = primaryContactPhone;
        return this;
    }

    public CreateSubaccountRequest metadata(String metadata) {
        this.metadata = metadata;
        return this;
    }
}
