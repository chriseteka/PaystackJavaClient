package com.chrisworks.paystackclient.domain.subaccount;

import com.chrisworks.paystackclient.domain.request.RequestBody;

import java.math.BigDecimal;

public class UpdateSubaccountRequest implements RequestBody<UpdateSubaccountRequest> {
    private final String business_name;
    private final String settlement_bank;
    private boolean active;
    private String account_number;
    private BigDecimal percentage_charge;
    private String description;
    private String primary_contact_email;
    private String primary_contact_name;
    private String primary_contact_phone;
    private String settlement_schedule;
    private String metadata;

    public UpdateSubaccountRequest(String businessName, String settlementBank) {
        this.business_name = businessName;
        this.settlement_bank = settlementBank;
    }

    public String getBusinessName() {
        return business_name;
    }

    public String getSettlementBank() {
        return settlement_bank;
    }

    public boolean isActive() {
        return active;
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

    public String getSettlementSchedule() {
        return settlement_schedule;
    }

    public UpdateSubaccountRequest accountNumber(String accountNumber) {
        this.account_number = accountNumber;
        return this;
    }

    public UpdateSubaccountRequest active(boolean active) {
        this.active = active;
        return this;
    }

    public UpdateSubaccountRequest percentageCharge(BigDecimal percentageCharge) {
        this.percentage_charge = percentageCharge;
        return this;
    }

    public UpdateSubaccountRequest description(String description) {
        this.description = description;
        return this;
    }

    public UpdateSubaccountRequest primaryContactEmail(String primaryContactEmail) {
        this.primary_contact_email = primaryContactEmail;
        return this;
    }

    public UpdateSubaccountRequest primaryContactName(String primaryContactName) {
        this.primary_contact_name = primaryContactName;
        return this;
    }

    public UpdateSubaccountRequest primaryContactPhone(String primaryContactPhone) {
        this.primary_contact_phone = primaryContactPhone;
        return this;
    }

    public UpdateSubaccountRequest settlementSchedule(String settlementSchedule) {
        this.settlement_schedule = settlementSchedule;
        return this;
    }

    public UpdateSubaccountRequest metadata(String metadata) {
        this.metadata = metadata;
        return this;
    }
}
