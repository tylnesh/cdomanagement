package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.Model;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModelRepository extends GenericRepository<Model> {

    Optional<Model> findById(Long id);
    List<Model> findAllByModelContainingIgnoreCase(String model);
    List<Model> findAllByManufacturerContainingIgnoreCase(String manufacturer);
    List<Model> findAllByYearFrom(Short yearFrom);
    List<Model> findAllByYearTo(Short yearTo);



}
