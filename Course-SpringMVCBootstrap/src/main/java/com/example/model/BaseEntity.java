package com.example.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


//@Entity
//@Inheritance( strategy = InheritanceType.JOINED)// mapped to relational database object
@MappedSuperclass // not entity
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    @Temporal( TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    private Date createDate;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public BaseEntity(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public BaseEntity(Date updateDate, Date createDate) {
        this.updateDate = updateDate;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}