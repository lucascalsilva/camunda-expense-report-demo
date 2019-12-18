package com.camunda.bpm.servicesdemo.model.expense;

import com.camunda.bpm.servicesdemo.model.BaseEntity;
import com.camunda.bpm.servicesdemo.model.common.ApprovalStatus;
import com.camunda.bpm.servicesdemo.model.common.Participant;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="EXPENSE_REPORT")
public class ExpenseReport extends BaseEntity {

    @Column(name="NUMBER")
    private String number;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="REQUESTER_ID")
    private Participant requester;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="EXPENSE_MANAGER_ID")
    private Participant expenseManager;

    @Column(name="REASON")
    private ExpenseReportReason reason;

    @Column(name="JUSTIFICATION")
    private String justification;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="EXPENSE_REPORT_ID")
    private List<Expense> expenses;

    @Column(name="LAST_APPROVAL")
    private ApprovalStatus lastApproval;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Participant getRequester() {
        return requester;
    }

    public void setRequester(Participant requester) {
        this.requester = requester;
    }

    public Participant getExpenseManager() {
        return expenseManager;
    }

    public void setExpenseManager(Participant expenseManager) {
        this.expenseManager = expenseManager;
    }

    public ExpenseReportReason getReason() {
        return reason;
    }

    public void setReason(ExpenseReportReason reason) {
        this.reason = reason;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public ApprovalStatus getLastApproval() {
        return lastApproval;
    }

    public void setLastApproval(ApprovalStatus lastApproval) {
        this.lastApproval = lastApproval;
    }
}
