package com.camunda.bpm.servicesdemo.controllers;

import com.camunda.bpm.servicesdemo.model.accountspayable.Invoice;
import com.camunda.bpm.servicesdemo.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("accounts-payable")
public class InvoiceController {

    private final InvoiceRepository repository;

    @PostMapping("/invoices")
    public Invoice merge(@RequestBody Invoice invoice) {
        return repository.save(invoice);
    }

    @GetMapping("/invoices")
    public List<Invoice> findAll() {
        return IterableUtils.toList(repository.findAll());
    }

}
