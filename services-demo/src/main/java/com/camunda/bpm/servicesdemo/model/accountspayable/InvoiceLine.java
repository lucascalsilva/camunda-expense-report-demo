package com.camunda.bpm.servicesdemo.model.accountspayable;

import com.camunda.bpm.servicesdemo.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="INVOICE_LINE")
public class InvoiceLine extends BaseEntity {

    @Column(name="LINE_NUMBER")
    private Long lineNumber;

    @Column(name="AMOUNT")
    private Double amount;

    @Column(name="QUANTIY")
    private Long quantity;

    @Column(name="DESCRIPTION")
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="INVOICE_ID")
    private Invoice invoice;

    public InvoiceLine(){

    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
