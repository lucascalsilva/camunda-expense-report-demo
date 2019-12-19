package com.camunda.bpm.sbexpensereportdemo.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
@Setter
@ConfigurationProperties(prefix = "templates")
public class TemplatesConfig {

    private String emailTemplate;
    private String subjectTemplate;
    private String typeVariable;
}
