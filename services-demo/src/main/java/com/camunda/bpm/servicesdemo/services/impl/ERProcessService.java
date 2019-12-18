package com.camunda.bpm.servicesdemo.services.impl;

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

    @Value(PropertyNames.CAMUNDA_REST_URL)
    private String CAMUNDA_REST_URL;

    @Value(PropertyNames.CAMUNDA_REST_EXPENSE_REPORT_PROCESS_START_PATH)
    private String CAMUNDA_REST_EXPENSE_REPORT_PROCESS_START_PATH;

    @Value(PropertyNames.CAMUNDA_REST_EXPENSE_REPORT_PROCESS_CANCEL_PATH)
    private String CAMUNDA_REST_EXPENSE_REPORT_PROCESS_CANCEL_PATH;

    private final RestTemplate restTemplate;

    public void start(ExpenseReport expenseReport) {
        URI url = buildURI(CAMUNDA_REST_URL, CAMUNDA_REST_EXPENSE_REPORT_PROCESS_START_PATH);
        restTemplate.postForEntity(url, expenseReport, ExpenseReport.class);
    }

    public void cancel(String erNumber) {
        URI url = buildURI(CAMUNDA_REST_URL, CAMUNDA_REST_EXPENSE_REPORT_PROCESS_CANCEL_PATH);
        Map<String, String> params = new HashMap<String, String>();
        params.put(VARIABLE_EXPENSEREPORTNUM_NAME, erNumber);
        restTemplate.postForLocation(url.toString(), null, params);
    }
}