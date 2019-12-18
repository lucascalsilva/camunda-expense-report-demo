package com.camunda.bpm.servicesdemo.repositories;

import com.camunda.bpm.servicesdemo.model.accountspayable.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}