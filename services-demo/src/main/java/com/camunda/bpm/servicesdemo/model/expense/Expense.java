package com.camunda.bpm.servicesdemo.model.expense;

import com.camunda.bpm.servicesdemo.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="EXPENSE")
public class Expense extends BaseEntity {

    @Column(name="AMOUNT")
    private Double amount;

    @Column(name="EXPENSE_DATE")
    private Date expenseDate;

    @Column(name="DESCRIPTION")
    private String description;

    @Lob
    @Column(name="RECEIPT_FILE_ENCODED")
    private String receiptFileEncoded;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="EXPENSE_REPORT_ID")
    private ExpenseReport expenseReport;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceiptFileEncoded() {
        return receiptFileEncoded;
    }

    public void setReceiptFileEncoded(String receiptFileEncoded) {
        this.receiptFileEncoded = receiptFileEncoded;
    }

    public ExpenseReport getExpenseReport() {
        return expenseReport;
    }

    public void setExpenseReport(ExpenseReport expenseReport) {
        this.expenseReport = expenseReport;
    }
}
