package com.camunda.bpm.sbexpensereportdemo.delegates;

import com.camunda.bpm.sbexpensereportdemo.services.CrudService;
import com.camunda.bpm.model.common.Approver;
import com.camunda.bpm.model.expenses.ExpenseReport;
import com.camunda.bpm.sbexpensereportdemo.mappers.ApprovalMapper;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.camunda.bpm.sbexpensereportdemo.process.ProcessVariables.*;

@Component
@RequiredArgsConstructor
public class ApproversDelegate implements JavaDelegate {

    private final CrudService<Approver> crudService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ExpenseReport expenseReport = getExpenseReport(delegateExecution);
        Long approvalLevel = getApprovalLevel(delegateExecution);

        List<Approver> approvers = crudService.findAll()
                .stream()
                .filter(approver -> approver.getApprovalLevel() <= approvalLevel)
                .collect(Collectors.toList());

        expenseReport.setApprovals(ApprovalMapper.INSTANCE.approversToApprovals(approvers));
        setExpenseReport(delegateExecution, expenseReport);
    }
}
