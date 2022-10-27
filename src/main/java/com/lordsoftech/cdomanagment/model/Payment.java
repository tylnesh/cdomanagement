package com.lordsoftech.cdomanagment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payment_type")
@Data
@NoArgsConstructor
public class Payment implements GenericEntity<Payment> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Column(columnDefinition = "varchar(255) default ''")
    private String paymentType;

    @CreationTimestamp
    @Column(name = "createdAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp updatedAt;

    @Override public Long getId() {
        return this.id;
    }


    @Override
    public void update(Payment source) {
        this.setPaymentType(source.getPaymentType());
        this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public Payment createNewInstance() {
        Payment newInstance = new Payment();
        newInstance.update(this);
        return newInstance;
    }

    public Payment(String paymentType) {
        this.setPaymentType(paymentType);
    }
 }

