package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Status;
import com.lordsoftech.cdomanagment.model.StatusList;

public interface StatusService {
    Status saveStatus(Status status);
    Status getStatus(Long id);
    Integer updateStatuses(StatusList updated);
    Integer deleteStatuses(StatusList deleted);
    StatusList searchStatuses(Status searched);
}
