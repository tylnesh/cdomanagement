package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.Status;
import com.lordsoftech.cdomanagment.model.StatusList;

public interface StatusRepository extends GenericRepository<Status>{

    Status findByStatus(String status);
    StatusList findAllByStatusContainingIgnoreCase(String status);
}
