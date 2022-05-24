package com.lordsoftech.cdomanagment.cdomanagment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dealers")
@Getter
@Setter
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealer_generator")
    @SequenceGenerator(name = "dealer_generator", sequenceName = "dealer_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(columnDefinition = "varchar(255) default ''")
    private String dealer;

    @Column(columnDefinition = "varchar(255) default ''")
    private String slug;

    public Dealer() {

    }
}
