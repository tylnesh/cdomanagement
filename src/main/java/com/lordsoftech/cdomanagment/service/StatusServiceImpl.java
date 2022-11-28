package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Status;
import com.lordsoftech.cdomanagment.model.StatusList;
import com.lordsoftech.cdomanagment.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final StatusRepository repository;

    @Override
    public Status saveStatus(Status status) {
        return repository.save(status);
    }

    @Override
    public Status getStatus(Long id) {
        Optional<Status> status = repository.findById(id);
        if (status.isPresent()) {
            return status.get();
        } else return null;
    }

    @Override
    public Integer updateStatuses(StatusList updated) {
        List<Status> dbDomain = new ArrayList<>();
        updated.getList().forEach((updatedItem) -> {
            dbDomain.add(getStatus(updatedItem.getId()));
            dbDomain.get(dbDomain.size()-1).update(updatedItem);
        });
        repository.saveAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public Integer deleteStatuses(StatusList deleted) {
        List<Status> dbDomain = new ArrayList<>();
        deleted.getList().forEach((deletedItem) -> {
            dbDomain.add(getStatus(deletedItem.getId()));
        });
        repository.deleteAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public List<Status> searchStatuses(Status searched) {
        return repository.findAllByStatusContainingIgnoreCase(searched.getStatus());
    }
}
