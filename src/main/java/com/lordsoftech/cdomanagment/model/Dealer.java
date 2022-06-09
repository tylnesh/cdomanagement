package com.lordsoftech.cdomanagment.model;

import java.security.Timestamp;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealer_generator")
    @SequenceGenerator(name = "dealer_generator", sequenceName = "dealer_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(columnDefinition = "varchar(255) default ''")
    private String dealer;

    @Column(columnDefinition = "varchar(255) default ''")
    private String slug;

    private Timestamp createdAt;
    private Timestamp updatedAt;

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
