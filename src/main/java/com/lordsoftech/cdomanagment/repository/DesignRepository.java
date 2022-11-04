package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.Design;
import com.lordsoftech.cdomanagment.model.DesignList;

import java.util.List;

public interface DesignRepository extends GenericRepository<Design>{
    Design findByDesign(String design);
    List<Design> findAllByDesignContainsIgnoreCase(String design);
}
