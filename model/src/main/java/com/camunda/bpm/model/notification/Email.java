package com.camunda.bpm.model.notification;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Email implements Serializable {

    private String to;
    private String cc;
    private String cco;
    private String subject;
    private String content;
}
