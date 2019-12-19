package com.camunda.bpm.sbexpensereportdemo.services.impl;

import com.camunda.bpm.model.accountspayable.Invoice;
import com.camunda.bpm.sbexpensereportdemo.config.ErpServicesConfig;
import com.camunda.bpm.sbexpensereportdemo.services.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService implements CrudService<Invoice> {

    private final ErpServicesConfig erpServicesConfig;
    private final RestTemplate erpServicesRestTemplate;

    public void merge(Invoice invoice){
        erpServicesRestTemplate.postForEntity(erpServicesConfig.getInvoicesServiceURI(), invoice, Invoice.class);
    }

    public List<Invoice> findAll() {
        return Arrays.asList(erpServicesRestTemplate.getForEntity(erpServicesConfig.getInvoicesServiceURI(), Invoice[].class).getBody());
    }

    public Invoice findById(Long id) {
        return null;
    }

    public void delete(Long id) {

    }

}
