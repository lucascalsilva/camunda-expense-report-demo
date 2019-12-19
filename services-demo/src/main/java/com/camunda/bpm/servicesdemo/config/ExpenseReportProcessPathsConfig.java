package com.camunda.bpm.servicesdemo.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
@Setter
@ConfigurationProperties(prefix = "services.process-engine.paths.expense-report-process")
public class ExpenseReportProcessPathsConfig {

    private String start;
    private String cancel;
}
