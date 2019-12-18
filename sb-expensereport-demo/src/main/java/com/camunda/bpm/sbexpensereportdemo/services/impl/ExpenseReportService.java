package com.camunda.bpm.sbexpensereportdemo.services.impl;

import com.camunda.bpm.model.expenses.ExpenseReport;
import com.camunda.bpm.sbexpensereportdemo.services.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseReportService implements CrudService<ExpenseReport> {

    public void merge(ExpenseReport object) {

    }

    public List<ExpenseReport> findAll() {
        return null;
    }

    public ExpenseReport findById(Long id) {
        return null;
    }

    public void delete(Long id) {

    }
}
