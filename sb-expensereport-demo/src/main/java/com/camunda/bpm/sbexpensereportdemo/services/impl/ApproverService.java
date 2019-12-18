package com.camunda.bpm.sbexpensereportdemo.services.impl;

import com.camunda.bpm.model.common.Approver;
import com.camunda.bpm.sbexpensereportdemo.services.CrudService;
import com.camunda.bpm.sbexpensereportdemo.util.PropertyNames;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static com.camunda.bpm.sbexpensereportdemo.util.ApplicationHelper.buildURI;

@Service
@RequiredArgsConstructor
public class ApproverService implements CrudService<Approver> {

    @Value(PropertyNames.ERP_REST_APPROVER_BASEPATH)
    private String REST_BASEPATH;

    @Value(PropertyNames.ERP_REST_URL)
    private String REST_URL;
    private final RestTemplate restTemplate;

    public void merge(Approver object) {

    }

    public List<Approver> findAll() {
        URI uri = buildURI(REST_URL, REST_BASEPATH);
        return Arrays.asList(restTemplate.getForEntity(uri, Approver[].class).getBody());
    }

    public Approver findById(Long id) {
        return null;
    }

    public void delete(Long id) {

    }

}
