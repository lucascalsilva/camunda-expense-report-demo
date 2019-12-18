package com.camunda.bpm.servicesdemo.model.accountspayable;

import com.camunda.bpm.servicesdemo.model.BaseEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="INVOICE")
public class Invoice extends BaseEntity {

    @Column(name="CREATION_DATE")
    private Date creationDate;

    @Column(name="TOTAL_AMOUNT")
    private Double totalAmount;

    @Column(name="DUE_DATE")
    private Date dueDate;

    @Column(name="DESCRIPTION")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="INVOICE_ID")
    private List<InvoiceLine> lines;

    public Invoice(){

    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }
}
