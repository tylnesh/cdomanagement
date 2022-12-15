package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.Design;

import java.util.List;

public interface DesignRepository extends GenericRepository<Design>{
    Design findByDesign(String design);
    List<Design> findAllByDesignContainsIgnoreCase(String design);
    List<Design> findAllByModels_ManufacturerContainsIgnoreCase(String manufacturer);
    List<Design> findAllByModels_ModelContainsIgnoreCase(String model);
}

