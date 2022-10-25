package com.lordsoftech.cdomanagment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "models")
@Data
public class BikeModel implements GenericEntity<BikeModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Column(columnDefinition = "varchar(255) default ''")
    private String manufacturer;
    @Column(columnDefinition = "varchar(255) default ''")
    private String model;

    private short yearFrom, yearTo;

    @CreationTimestamp
    @Column(name = "createdAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp updatedAt;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void update(BikeModel source) {
        this.setManufacturer(source.getManufacturer());
        this.setModel(source.getModel());
        this.setYearFrom(source.getYearFrom());
        this.setYearTo(source.getYearTo());
        this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    }
    @Override
    public BikeModel createNewInstance() {
        BikeModel newInstance = new BikeModel();
        newInstance.update(this);
        return newInstance;
    }
}
