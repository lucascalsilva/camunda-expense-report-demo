package com.camunda.bpm.sbexpensereportdemo.util;

import com.camunda.bpm.sbexpensereportdemo.interceptors.RequestResponseLoggingInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Component
public class CustomRestTemplateBuilder {

    public RestTemplate build(Integer timeout) {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(timeout))
                .setReadTimeout(Duration.ofMillis(timeout))
                .additionalInterceptors(new RequestResponseLoggingInterceptor())
                .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .build();
    }
}
