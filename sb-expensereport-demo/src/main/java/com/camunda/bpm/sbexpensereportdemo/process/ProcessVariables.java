package com.camunda.bpm.sbexpensereportdemo.process;

import com.camunda.bpm.model.expenses.ExpenseReport;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Component;

import static org.camunda.spin.Spin.JSON;

public class ProcessVariables {

    public static final ExpenseReport getExpenseReport(DelegateExecution delegateExecution){
        Object obj = delegateExecution.getVariable(ProcessConstants.VARIABLE_EXPENSEREPORT_NAME);
        return (ExpenseReport) obj;
    }

    public static final void setExpenseReport(DelegateExecution delegateExecution, ExpenseReport expenseReport){
        ObjectValue expenseReportJson = Variables.objectValue(expenseReport)
                .create();
        delegateExecution.setVariable(ProcessConstants.VARIABLE_EXPENSEREPORT_NAME, expenseReportJson);
    }

    public static final Long getApprovalLevel(DelegateExecution delegateExecution){
        return (Long) delegateExecution.getVariable(ProcessConstants.VARIABLE_APPROVALLEVEL_NAME);
    }

    public static final void setApprovalLevel(DelegateExecution delegateExecution, Long approvalLevel){
        delegateExecution.setVariable(ProcessConstants.VARIABLE_APPROVALLEVEL_NAME, approvalLevel);
    }
}
