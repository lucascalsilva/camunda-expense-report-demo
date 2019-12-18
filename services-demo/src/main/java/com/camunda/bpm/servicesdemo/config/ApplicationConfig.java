package com.camunda.bpm.servicesdemo.config;

import com.camunda.bpm.servicesdemo.util.PropertyNames;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@EnableScheduling
@Configuration
public class ApplicationConfig {

    @Value(PropertyNames.CAMUNDA_REST_TIMEOUT)
    private Long timeout;

    @Bean
    public RestTemplate standardRestTemplate(ClientHttpRequestInterceptor clientHttpRequestInterceptor){
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(timeout))
                .setReadTimeout(Duration.ofMillis(timeout))
                .additionalInterceptors(clientHttpRequestInterceptor)
                .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .build();
    }
}