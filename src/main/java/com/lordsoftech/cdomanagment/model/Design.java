package com.lordsoftech.cdomanagment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "designs")
@Getter
@Setter
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "`designs_models`",
            joinColumns = {
                    @JoinColumn(name = "`design_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "`model_id`")
            }
    )
    private Set<Model> models;



    @CreationTimestamp
    @Column(name = "createdAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp updatedAt;


    @Override
    public void update(Design source) {
        this.design = source.getDesign();
        this.pathToImage = source.getPathToImage();
        this.models = source.getModels();
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
