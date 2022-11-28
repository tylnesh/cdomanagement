package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.Status;
import com.lordsoftech.cdomanagment.model.StatusList;

import java.util.List;

public interface StatusRepository extends GenericRepository<Status>{

    Status findByStatus(String status);
    List<Status> findAllByStatusContainingIgnoreCase(String status);
}
