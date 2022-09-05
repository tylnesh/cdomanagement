package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.Design;

public interface DesignRepository extends GenericRepository<Design>{
    Design findByDesign(String design);
}
