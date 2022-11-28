package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Design;
import com.lordsoftech.cdomanagment.model.Model;
import com.lordsoftech.cdomanagment.model.ModelList;
import com.lordsoftech.cdomanagment.repository.DesignRepository;
import com.lordsoftech.cdomanagment.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional

public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final DesignRepository designRepository;



    @Override
    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model getModel(Long id) {
        Optional<Model> model = modelRepository.findById(id);
        if (model.isPresent()) return model.get();
        return null;
    }

    @Override
    public Integer updateModels(ModelList updated) {
        List<Model> dbDomain = new ArrayList<>();
        updated.getList().forEach((updatedItem) -> {
            dbDomain.add(getModel(updatedItem.getId()));
            dbDomain.get(dbDomain.size()-1).update(updatedItem);
        });
        modelRepository.saveAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public Integer deleteModels(ModelList deleted) {
        List<Model> dbDomain = new ArrayList<>();
        deleted.getList().forEach((deletedItem) -> {
            dbDomain.add(getModel(deletedItem.getId()));
        });
        modelRepository.deleteAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public List<Model> searchModels(Model searched) {
        List<Model> dbDomain = new ArrayList<>();
        dbDomain.addAll(modelRepository.findAllByModelContainingIgnoreCase(searched.getModel()));
        dbDomain.addAll(modelRepository.findAllByManufacturerContainingIgnoreCase(searched.getManufacturer()));
        dbDomain.addAll(modelRepository.findAllByYearFrom(searched.getYearFrom()));
        dbDomain.addAll(modelRepository.findAllByYearTo(searched.getYearTo()));
        return dbDomain;
    }

    @Override
    public void linkDesignModel(Model pairModel, Design pairDesign) {
        log.info("Linking model {} and design {}", pairModel, pairDesign);
        Optional<Model> model = modelRepository.findById(pairModel.getId());
        Optional<Design> design = designRepository.findById(pairDesign.getId());
        if (model.isPresent() && design.isPresent()) {
            model.get().getDesigns().add(design.get());
            design.get().getModels().add(model.get());
        }
    }
}
