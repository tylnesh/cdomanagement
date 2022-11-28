package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Status;
import com.lordsoftech.cdomanagment.model.StatusList;

import java.util.List;

public interface StatusService {
    Status saveStatus(Status status);
    Status getStatus(Long id);
    Integer updateStatuses(StatusList updated);
    Integer deleteStatuses(StatusList deleted);
    List<Status> searchStatuses(Status searched);
}
