package com.lordsoftech.cdomanagment.model;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Data
@Table(name = "roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Enumerated(EnumType.STRING)
    private RoleName name;
}
