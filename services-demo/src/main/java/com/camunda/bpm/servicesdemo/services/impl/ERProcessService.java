package com.camunda.bpm.servicesdemo.services.impl;

import com.camunda.bpm.servicesdemo.config.ProcessEngineServicesConfig;
import com.camunda.bpm.servicesdemo.model.expense.ExpenseReport;
import com.camunda.bpm.servicesdemo.services.ProcessService;
import com.camunda.bpm.servicesdemo.util.CustomRestTemplateBuilder;
import com.camunda.bpm.servicesdemo.util.PropertyNames;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static com.camunda.bpm.servicesdemo.util.ApplicationConstants.VARIABLE_EXPENSEREPORTNUM_NAME;
import static com.camunda.bpm.servicesdemo.util.ApplicationHelper.buildURI;

@Service
@RequiredArgsConstructor
public class ERProcessService implements ProcessService<ExpenseReport, String> {

    private final ProcessEngineServicesConfig processEngineServicesConfig;

    private final RestTemplate restTemplate;

    public void start(ExpenseReport expenseReport) {
        restTemplate.postForEntity(processEngineServicesConfig.getExpenseReportProcessStartURI(), expenseReport, ExpenseReport.class);
    }

    public void cancel(String erNumber) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(VARIABLE_EXPENSEREPORTNUM_NAME, erNumber);
        restTemplate.postForLocation(processEngineServicesConfig.getExpenseReportProcessCancelURI().toString(), null, params);
    }
}