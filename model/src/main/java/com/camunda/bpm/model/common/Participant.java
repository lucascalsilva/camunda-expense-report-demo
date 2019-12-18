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
public class Participant implements Serializable {

    private String name;
    private String user;
    private String email;
}
