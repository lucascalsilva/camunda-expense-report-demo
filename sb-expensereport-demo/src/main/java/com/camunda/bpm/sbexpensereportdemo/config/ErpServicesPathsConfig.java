package com.camunda.bpm.sbexpensereportdemo.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static com.camunda.bpm.sbexpensereportdemo.util.ApplicationHelper.buildURI;

@Component
@RequiredArgsConstructor
@Getter
@Setter
@ConfigurationProperties(prefix = "services.erp.paths")
public class ErpServicesPathsConfig {

    private String approvers;
    private String invoices;
    private String emails;
}
