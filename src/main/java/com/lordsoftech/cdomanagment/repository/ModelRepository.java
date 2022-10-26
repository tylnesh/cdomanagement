package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.Model;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends GenericRepository<Model> {

    Model findByModel(String model);
    List<Model> findAllByModelContainingIgnoreCase(String model);
    List<Model> findAllByManufacturerContainingIgnoreCase(String manufacturer);
    List<Model> findAllByYearFrom(Short yearFrom);
    List<Model> findAllByYearTo(Short yearTo);



}
