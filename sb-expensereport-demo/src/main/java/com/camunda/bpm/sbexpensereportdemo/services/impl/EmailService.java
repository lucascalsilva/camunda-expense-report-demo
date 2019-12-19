package com.camunda.bpm.sbexpensereportdemo.services.impl;

import com.camunda.bpm.model.notification.Email;
import com.camunda.bpm.sbexpensereportdemo.config.ErpServicesConfig;
import com.camunda.bpm.sbexpensereportdemo.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class EmailService implements NotificationService<Email> {

    private final ErpServicesConfig erpServicesConfig;
    private final RestTemplate erpServicesRestTemplate;

    public void send(Email notification) {
        erpServicesRestTemplate.postForEntity(erpServicesConfig.getEmailsServiceURI(), notification, Email.class);
    }
}
