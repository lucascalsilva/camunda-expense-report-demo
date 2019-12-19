package com.camunda.bpm.sbexpensereportdemo.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
@Setter
@ConfigurationProperties(prefix = "exception.messages")
public class ExceptionMessagesConfig {

    private String requesterNotFound;
}
