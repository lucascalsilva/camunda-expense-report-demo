package com.camunda.bpm.sbexpensereportdemo.controllers;

import com.camunda.bpm.model.expenses.ExpenseReport;
import com.camunda.bpm.sbexpensereportdemo.config.ExceptionMessagesConfig;
import com.camunda.bpm.sbexpensereportdemo.exceptions.RequesterNotFound;
import com.camunda.bpm.sbexpensereportdemo.process.ProcessConstants;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class ExpenseReportRestController {

    private final ProcessEngine processEngine;
    private final ExceptionMessagesConfig exceptionMessagesConfig;

    @PostMapping("/expense-reports")
    public void startExpenseReportProcess(@RequestBody ExpenseReport expenseReport){
        User requester = processEngine.getIdentityService().
                createUserQuery().userId(expenseReport.getRequester().getUser()).singleResult();

        if(requester == null) {
            throw new RequesterNotFound(exceptionMessagesConfig.getRequesterNotFound());
        }

        expenseReport.getRequester().setEmail(requester.getEmail());
        expenseReport.getRequester().setName(requester.getFirstName()+" "+requester.getLastName());

        expenseReport.setTotalAmount(expenseReport.getExpenses().
                stream().mapToDouble(o -> o.getAmount()).sum());

        HashMap<String, Object> variables = new HashMap<String, Object>();
        variables.put(ProcessConstants.VARIABLE_EXPENSEREPORT_NAME, Variables.objectValue(expenseReport)
                .serializationDataFormat(Variables.SerializationDataFormats.JSON).create());

        processEngine.getRuntimeService().startProcessInstanceByKey(ProcessConstants.EXPENSE_REPORT_APPROVAL_PROCESS_KEY, expenseReport.getNumber(),variables);

    }

    @PostMapping("/expense-reports/{expenseReportNumber}/cancel")
    public void cancelExpenseReportProcess(@PathVariable String expenseReportNumber){
        processEngine.getRuntimeService().createMessageCorrelation(ProcessConstants.MESSAGE_CANCELPROCESS)
                .processInstanceBusinessKey(expenseReportNumber)
                .correlate();
    }

    @PostMapping("/expense-reports/{expenseReportNumber}/needsChanges")
    public void needsChangesExpenseReport(@PathVariable String expenseReportNumber, @RequestBody ExpenseReport expenseReport){
        HashMap<String, Object> variables = new HashMap<String, Object>();
        variables.put(ProcessConstants.VARIABLE_EXPENSEREPORT_NAME, Variables.objectValue(expenseReport)
                .serializationDataFormat(Variables.SerializationDataFormats.JSON).create());

        processEngine.getRuntimeService().createMessageCorrelation(ProcessConstants.MESSAGE_REQUESTCHANGES)
                .processInstanceBusinessKey(expenseReportNumber).setVariables(variables).correlate();
    }

    @PostMapping("/expense-reports/{expenseReportNumber}/sendChanges")
    public void sendChangesExpenseReportProcess(@PathVariable String expenseReportNumber, @RequestBody ExpenseReport expenseReport){
        HashMap<String, Object> variables = new HashMap<String, Object>();
        variables.put(ProcessConstants.VARIABLE_EXPENSEREPORT_NAME, Variables.objectValue(expenseReport)
                .serializationDataFormat(Variables.SerializationDataFormats.JSON).create());

        processEngine.getRuntimeService().createMessageCorrelation(ProcessConstants.MESSAGE_CHANGESRECEIVED)
                .processInstanceBusinessKey(expenseReportNumber).setVariables(variables).correlate();
    }

}