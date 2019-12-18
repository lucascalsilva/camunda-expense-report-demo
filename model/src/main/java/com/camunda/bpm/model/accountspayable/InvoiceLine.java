package com.camunda.bpm.model.accountspayable;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class InvoiceLine implements Serializable {

    private Long lineNumber;
    private Double amount;
    private Long quantity;
    private String description;
}
