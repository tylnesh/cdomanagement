package com.lordsoftech.cdomanagment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "status")
@Data
@NoArgsConstructor
public class Status implements GenericEntity<Status>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Column(columnDefinition = "varchar(255) default ''")
    private String status;
    @Column(columnDefinition = "varchar(7) default ''")
    private String color;


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
    public void update(Status source) {
        this.setStatus(source.getStatus());
        this.setColor(source.getColor());
        this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public Status createNewInstance() {
        Status newInstance = new Status();
        newInstance.update(this);
        return newInstance;
    }

    public Status(String status, String color) {
        this.setStatus(status);
        this.setColor(color);
    }

}
