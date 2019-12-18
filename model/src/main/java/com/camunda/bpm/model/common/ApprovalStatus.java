package com.camunda.bpm.model.common;

import java.io.Serializable;

public enum ApprovalStatus implements Serializable {
    APPROVED("Approved"), DECLINED("Declined"), REQUEST_CHANGES("Changes Needed"),
    CANCELLED("Cancelled"), PAYMENT_ISSUES("Payment with Issues");

    private String description;

    ApprovalStatus(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
