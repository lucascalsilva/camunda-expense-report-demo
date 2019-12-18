package com.camunda.bpm.model.expenses;

import com.camunda.bpm.model.common.Approval;
import com.camunda.bpm.model.common.ApprovalStatus;
import com.camunda.bpm.model.common.Participant;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExpenseReport implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;
    private String number;
    private Participant requester;
    private Participant expenseManager;
    private ExpenseReportReason reason;
    private String justification;
    private Date creationDate;
    private Double totalAmount;
    private List<Approval> approvals;
    private List<Expense> expenses;
    private ApprovalStatus lastApproval;
    private String changesDescription;
}
