package com.camunda.bpm.servicesdemo.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;

import static com.camunda.bpm.servicesdemo.util.ApplicationHelper.buildURI;

@Component
@RequiredArgsConstructor
@Getter
@Setter
@ConfigurationProperties(prefix = "services.process-engine")
public class ProcessEngineServicesConfig {

    private Long timeout;
    private String url;
    private final ExpenseReportProcessPathsConfig expenseReportProcessConfig;

    public URI getExpenseReportProcessStartURI(){
        return buildURI(url, expenseReportProcessConfig.getStart());
    }

    public URI getExpenseReportProcessCancelURI(){
        return buildURI(url, expenseReportProcessConfig.getCancel());
    }

}
