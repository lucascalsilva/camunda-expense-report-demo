package com.camunda.bpm.model.expenses;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Expense implements Serializable {

    private Double amount;
    @EqualsAndHashCode.Include
    private Long id;
    private Date expenseDate;
    private String description;
    private String receiptFileEncoded;
}
