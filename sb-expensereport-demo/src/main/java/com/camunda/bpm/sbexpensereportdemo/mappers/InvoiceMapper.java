package com.camunda.bpm.sbexpensereportdemo.mappers;

import com.camunda.bpm.model.accountspayable.Invoice;
import com.camunda.bpm.model.accountspayable.InvoiceLine;
import com.camunda.bpm.model.expenses.Expense;
import com.camunda.bpm.model.expenses.ExpenseReport;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Mapper
public abstract class InvoiceMapper {

    public static InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    @Mappings({
            @Mapping(target = "description", source = "justification"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "lines", source = "expenses")
    })
    public abstract Invoice expenseReportToInvoice(ExpenseReport expenseReport);

    public abstract List<InvoiceLine> expensesToInvoiceLines(List<Expense> expenses);

    @Mappings({
            @Mapping(target = "quantity", constant = "1")
    })
    public abstract InvoiceLine expenseToInvoiceLine(Expense expense);

    @AfterMapping
    protected void setInvoiceLineNumbers(@MappingTarget Invoice result){
        AtomicLong atomicLong = new AtomicLong(1);
        result.getLines().stream().forEach(i -> i.setLineNumber(atomicLong.getAndIncrement()));
    }
}
