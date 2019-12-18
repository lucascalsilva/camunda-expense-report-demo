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
public class Approval implements Serializable {

    private ApprovalStatus approvalStatus;
    private Approver approver;
}
