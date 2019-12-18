package com.camunda.bpm.servicesdemo.controllers;

import com.camunda.bpm.servicesdemo.services.impl.ERProcessService;
import com.camunda.bpm.servicesdemo.model.expense.ExpenseReport;
import com.camunda.bpm.servicesdemo.repositories.ExpenseReportRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("expenses")
public class ExpenseReportController {

    private final ExpenseReportRepository repository;
    private final ERProcessService erProcessService;

    @PostMapping("/expense-reports")
    @Transactional
    public ExpenseReport save(@RequestBody ExpenseReport expenseReport) {
        ExpenseReport savedExpenseReport = repository.save(expenseReport);
        erProcessService.start(savedExpenseReport);
        return savedExpenseReport;
    }

    @GetMapping("/expense-reports")
    public List<ExpenseReport> findAll() {
        return IterableUtils.toList(repository.findAll());
    }
}
