package io.github.chriseteka.paystackclient.domain.subaccount;

import io.github.chriseteka.paystackclient.domain.request.RequestBody;

import java.math.BigDecimal;

public class UpdateSubAccountRequest implements RequestBody<UpdateSubAccountRequest> {
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

    public UpdateSubAccountRequest(String businessName, String settlementBank) {
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

    public UpdateSubAccountRequest accountNumber(String accountNumber) {
        this.account_number = accountNumber;
        return this;
    }

    public UpdateSubAccountRequest active(boolean active) {
        this.active = active;
        return this;
    }

    public UpdateSubAccountRequest percentageCharge(BigDecimal percentageCharge) {
        this.percentage_charge = percentageCharge;
        return this;
    }

    public UpdateSubAccountRequest description(String description) {
        this.description = description;
        return this;
    }

    public UpdateSubAccountRequest primaryContactEmail(String primaryContactEmail) {
        this.primary_contact_email = primaryContactEmail;
        return this;
    }

    public UpdateSubAccountRequest primaryContactName(String primaryContactName) {
        this.primary_contact_name = primaryContactName;
        return this;
    }

    public UpdateSubAccountRequest primaryContactPhone(String primaryContactPhone) {
        this.primary_contact_phone = primaryContactPhone;
        return this;
    }

    public UpdateSubAccountRequest settlementSchedule(String settlementSchedule) {
        this.settlement_schedule = settlementSchedule;
        return this;
    }

    public UpdateSubAccountRequest metadata(String metadata) {
        this.metadata = metadata;
        return this;
    }
}
