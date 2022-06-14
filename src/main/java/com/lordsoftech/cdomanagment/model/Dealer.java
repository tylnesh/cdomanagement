package com.lordsoftech.cdomanagment.model;

import java.sql.Time;

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

    @Column(columnDefinition = "varchar(10) default ''")
    private String slug;

    //@Column(name = "createdAt", columnDefinition = "timestamp default current_timestamp")
    private Time createdAt;
    //@Column(name = "updatedAt", columnDefinition = "timestamp default current_timestamp")
    private Time updatedAt;

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
    public Time getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public Time getUpdatedAt() {
        return this.updatedAt;
    }
}
