package com.camunda.bpm.model.common;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Approver implements Serializable {

    private Participant participant;

    private Long approvalLevel;
}
