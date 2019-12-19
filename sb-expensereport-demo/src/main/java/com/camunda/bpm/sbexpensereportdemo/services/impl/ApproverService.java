package com.camunda.bpm.sbexpensereportdemo.services.impl;

import com.camunda.bpm.model.common.Approver;
import com.camunda.bpm.sbexpensereportdemo.config.ErpServicesConfig;
import com.camunda.bpm.sbexpensereportdemo.services.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApproverService implements CrudService<Approver> {
    private final RestTemplate erpServicesRestTemplate;
    private final ErpServicesConfig erpServicesConfig;

    public void merge(Approver object) {

    }

    public List<Approver> findAll() {
        return Arrays.asList(erpServicesRestTemplate.getForEntity(erpServicesConfig.getApproversServiceURI(), Approver[].class).getBody());
    }

    public Approver findById(Long id) {
        return null;
    }

    public void delete(Long id) {

    }

}
