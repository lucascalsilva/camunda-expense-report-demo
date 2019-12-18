package com.camunda.bpm.sbexpensereportdemo.services.impl;

import com.camunda.bpm.model.accountspayable.Invoice;
import com.camunda.bpm.sbexpensereportdemo.services.CrudService;
import com.camunda.bpm.sbexpensereportdemo.util.CustomRestTemplateBuilder;
import com.camunda.bpm.sbexpensereportdemo.util.PropertyNames;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static com.camunda.bpm.sbexpensereportdemo.util.ApplicationHelper.buildURI;

@Service
@RequiredArgsConstructor
public class InvoiceService implements CrudService<Invoice> {

    @Value(PropertyNames.ERP_REST_INVOICE_BASEPATH)
    private String REST_BASEPATH;

    @Value(PropertyNames.ERP_REST_URL)
    private String REST_URL;
    private RestTemplate restTemplate;

    public void merge(Invoice invoice){
        URI uri = buildURI(REST_URL, REST_BASEPATH);
        restTemplate.postForEntity(uri, invoice, Invoice.class);
    }

    public List<Invoice> findAll() {
        URI uri = buildURI(REST_URL, REST_BASEPATH);
        return restTemplate.getForEntity(uri, List.class).getBody();
    }

    public Invoice findById(Long id) {
        return null;
    }

    public void delete(Long id) {

    }

}
