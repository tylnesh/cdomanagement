package com.lordsoftech.cdomanagment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "printers")
@Data
public class Printer implements GenericEntity<Printer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(columnDefinition = "varchar(255) default ''")
    private String printer;

    @CreationTimestamp
    @Column(name = "createdAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt", columnDefinition = "timestamp default current_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Berlin")
    private java.sql.Timestamp updatedAt;

    public Printer() {

    }

    public Printer(String printer) {
        this.printer = printer;
    }



    @Override
    public void update(Printer source) {
        this.setPrinter( source.getPrinter());
        this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

    }

    @Override
    public Printer createNewInstance() {
        Printer newInstance = new Printer();
        newInstance.update(this);
        return newInstance;
    }

}
