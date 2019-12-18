package com.camunda.bpm.sbexpensereportdemo.services.impl;

import com.camunda.bpm.model.notification.Email;
import com.camunda.bpm.sbexpensereportdemo.services.NotificationService;
import com.camunda.bpm.sbexpensereportdemo.util.CustomRestTemplateBuilder;
import com.camunda.bpm.sbexpensereportdemo.util.PropertyNames;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static com.camunda.bpm.sbexpensereportdemo.util.ApplicationHelper.buildURI;

@Service
@RequiredArgsConstructor
public class EmailService implements NotificationService<Email> {

    @Value(PropertyNames.ERP_REST_EMAIL_BASEPATH)
    private String REST_BASEPATH;

    @Value(PropertyNames.ERP_REST_URL)
    private String REST_URL;
    private final RestTemplate restTemplate;

    public void send(Email notification) {
        URI uri = buildURI(REST_URL, REST_BASEPATH);
        restTemplate.postForEntity(uri, notification, Email.class);
    }
}
