package com.lordsoftech.cdomanagment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "designs")
@Data
@RequiredArgsConstructor
public class Design implements GenericEntity<Design> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Column(columnDefinition = "varchar(255) default ''")
    private String design;
    @Column(columnDefinition = "varchar(255) default ''")
    private String pathToImage;

    @ManyToMany
    private Set<Model> models;



    private Timestamp createdAt;
    private Timestamp updatedAt;


    @Override
    public void update(Design source) {
        this.design = source.getDesign();
        this.pathToImage = source.getPathToImage();
        this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public Design createNewInstance() {
        Design newInstance = new Design();
        newInstance.update(this);
        return newInstance;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public Design(String design, String pathToImage) {
        this.design = design;
        this.pathToImage = pathToImage;
        this.models = new HashSet<>();
    }
}
