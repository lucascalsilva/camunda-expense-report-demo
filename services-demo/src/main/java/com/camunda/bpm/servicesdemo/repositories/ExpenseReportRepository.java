package com.camunda.bpm.servicesdemo.repositories;

import com.camunda.bpm.servicesdemo.model.expense.ExpenseReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseReportRepository extends JpaRepository<ExpenseReport, Long> {
}
