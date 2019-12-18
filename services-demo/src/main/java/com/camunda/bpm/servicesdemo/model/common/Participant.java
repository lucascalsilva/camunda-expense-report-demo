package com.camunda.bpm.servicesdemo.model.common;

import com.camunda.bpm.servicesdemo.model.BaseEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PARTICIPANT")
public class Participant extends BaseEntity {

    @Column(name="NAME")
    private String name;

    @Column(name="USER")
    private String user;

    @Column(name="EMAIL")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
