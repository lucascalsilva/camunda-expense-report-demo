package com.camunda.bpm.servicesdemo.model;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    @Column(name="CREATION_DATE", updatable = false)
    private Date creationDate;
    @Column(name="LAST_UPDATE_DATE", insertable = false)
    private Date lastUpdateDate;

    @PrePersist
    public void onPrePersist(){
        this.creationDate = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    public void onPreUpdate(){
        this.lastUpdateDate = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
