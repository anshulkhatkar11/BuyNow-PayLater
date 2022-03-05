package com.anshul.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Merchant {
    @Id
    String merchantName;
    String emailId;
    Double merchantFees;
    double feesPaid;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Double getMerchantFees() {
        return merchantFees;
    }

    public void setMerchantFees(Double merchantFees) {
        this.merchantFees = merchantFees;
    }

    public double getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(double amountTotal) {
        this.amountTotal = amountTotal;
    }

    public Double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(Double feesPaid) {
        this.feesPaid = feesPaid;
    }

    double amountTotal;
}
