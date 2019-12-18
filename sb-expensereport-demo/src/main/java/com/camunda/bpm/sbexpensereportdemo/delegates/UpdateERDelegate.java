package com.camunda.bpm.sbexpensereportdemo.delegates;

import com.camunda.bpm.model.expenses.ExpenseReport;
import com.camunda.bpm.sbexpensereportdemo.services.CrudService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static com.camunda.bpm.sbexpensereportdemo.process.ProcessVariablesUtil.*;

@Component
@RequiredArgsConstructor
public class UpdateERDelegate implements JavaDelegate {

    private final CrudService<ExpenseReport> crudServiceAdapter;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ExpenseReport expenseReport = getExpenseReport(delegateExecution);
        crudServiceAdapter.merge(expenseReport);
    }
}
