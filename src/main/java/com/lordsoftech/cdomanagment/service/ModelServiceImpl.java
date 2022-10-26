package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.model.Model;
import com.lordsoftech.cdomanagment.model.ModelList;
import com.lordsoftech.cdomanagment.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository repository;

    @Override
    public Model saveModel(Model model) {
        return repository.save(model);
    }

    @Override
    public Model getModel(Long id) {
        Optional<Model> model = repository.findById(id);
        if (model.isPresent()) return model.get();
        return null;
    }

    @Override
    public Integer updateModels(ModelList updated) {
        List<Model> dbDomain = new ArrayList<>();
        updated.getModelList().forEach((updatedDealer) -> {
            dbDomain.add(getModel(updatedDealer.getId()));
            dbDomain.get(dbDomain.size()-1).update(updatedDealer);
        });
        repository.saveAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public Integer deleteModels(ModelList deleted) {
        List<Model> dbDomain = new ArrayList<>();
        deleted.getModelList().forEach((deletedDealer) -> {
            dbDomain.add(getModel(deletedDealer.getId()));
        });
        repository.deleteAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public List<Model> searchModels(Model searched) {
        List<Model> dbDomain = new ArrayList<>();
        dbDomain.addAll(repository.findAllByModelContainingIgnoreCase(searched.getModel()));
        dbDomain.addAll(repository.findAllByManufacturerContainingIgnoreCase(searched.getManufacturer()));
        dbDomain.addAll(repository.findAllByYearFrom(searched.getYearFrom()));
        dbDomain.addAll(repository.findAllByYearTo(searched.getYearTo()));
        return dbDomain;
    }
}
