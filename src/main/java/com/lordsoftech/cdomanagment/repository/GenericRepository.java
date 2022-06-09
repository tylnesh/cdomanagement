package com.lordsoftech.cdomanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.lordsoftech.cdomanagment.model.GenericEntity;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity<T>> extends JpaRepository<T, Long> {

}
