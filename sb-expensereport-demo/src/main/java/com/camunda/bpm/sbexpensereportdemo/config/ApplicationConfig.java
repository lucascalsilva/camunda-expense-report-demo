package com.camunda.bpm.sbexpensereportdemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final ErpServicesConfig erpServicesConfig;

    @Bean
    public RestTemplate erpServicesRestTemplate(ClientHttpRequestInterceptor clientHttpRequestInterceptor){
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(erpServicesConfig.getTimeout()))
                .setReadTimeout(Duration.ofMillis(erpServicesConfig.getTimeout()))
                .additionalInterceptors(clientHttpRequestInterceptor)
                .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .build();
    }
}
