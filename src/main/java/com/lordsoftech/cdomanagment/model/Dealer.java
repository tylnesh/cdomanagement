package com.lordsoftech.cdomanagment.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "dealers")
@Data
public class Dealer implements GenericEntity<Dealer> {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealer_generator")
    //@SequenceGenerator(name = "dealer_generator", sequenceName = "dealer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(columnDefinition = "varchar(255) default ''")
    private String dealer;

    @Column(columnDefinition = "varchar(10) default ''")
    private String slug;

    @CreationTimestamp
    @Column(name = "createdAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp updatedAt;

    public Dealer() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void update(Dealer source) {
        this.setDealer(source.getDealer());
        this.setSlug(source.getSlug());
        this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public Dealer createNewInstance() {
        Dealer newInstance = new Dealer();
        newInstance.update(this);
        return newInstance;
    }

    @Override
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

}
