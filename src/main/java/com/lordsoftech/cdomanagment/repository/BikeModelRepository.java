package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.BikeModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeModelRepository extends GenericRepository<BikeModel> {

    BikeModel findByModel(String model);


}
