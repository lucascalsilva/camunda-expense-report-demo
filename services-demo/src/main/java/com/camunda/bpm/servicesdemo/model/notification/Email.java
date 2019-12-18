package com.camunda.bpm.servicesdemo.model.notification;

import com.camunda.bpm.servicesdemo.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="EMAIL_MESSAGE")
public class Email extends BaseEntity {

    @Column(name="TO")
    private String to;

    @Column(name="CC")
    private String cc;

    @Column(name="CCO")
    private String cco;

    @Column(name="SUBJECT")
    private String subject;

    @Lob
    @Column(name="CONTENT")
    private String content;

    @Column(name="SENT")
    private Boolean sent = false;

    public Email() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCco() {
        return cco;
    }

    public void setCco(String cco) {
        this.cco = cco;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }
}
