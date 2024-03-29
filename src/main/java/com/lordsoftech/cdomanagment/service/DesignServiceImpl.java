package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Design;
import com.lordsoftech.cdomanagment.model.DesignList;
import com.lordsoftech.cdomanagment.model.Model;
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
public class DesignServiceImpl implements DesignService{

    private final DesignRepository designRepository;
    private final ModelRepository modelRepository;

    @Override
    public Design saveDesign(Design design) {
        return designRepository.save(design);
    }

    @Override
    public Design getDesign(String design) {
        return designRepository.findByDesign(design);
    }

    @Override
    public Design getDesign(Long id) {
        Optional<Design> design = designRepository.findById(id);
        if (design.isPresent()) {
            return design.get();
        }
        return null;
    }

    @Override
    public Integer updateDesigns(DesignList updated) {
        List<Design> dbDomain = new ArrayList<>();
        updated.getList().forEach((updatedItem) -> {
            dbDomain.add(getDesign(updatedItem.getId()));
            dbDomain.get(dbDomain.size()-1).update(updatedItem);
        });
        designRepository.saveAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public Integer deleteDesigns(DesignList deleted) {
        List<Design> dbDomain = new ArrayList<>();
        deleted.getList().forEach((deletedItem) -> {
            dbDomain.add(getDesign(deletedItem.getId()));
        });
        designRepository.deleteAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public List<Design> searchDesigns(Design searched) {
        List<Design> searchResult = new ArrayList<>();
        searchResult.addAll(designRepository.findAllByDesignContainsIgnoreCase(searched.getDesign()));
        searchResult.addAll(designRepository.findAllByModels_ModelContainsIgnoreCase(searched.getDesign()));
        searchResult.addAll(designRepository.findAllByModels_ManufacturerContainsIgnoreCase(searched.getDesign()));

        return searchResult;
    }
    @Override
    public void linkDesignModel(Design pairDesign, Model pairModel) {
        //log.info("Linking model {} and design {}", pairModel, pairDesign);
        Optional<Model> model = modelRepository.findById(pairModel.getId());
        Optional<Design> design = designRepository.findById(pairDesign.getId());
        if (model.isPresent() && design.isPresent()) {
            model.get().getDesigns().add(design.get());
            design.get().getModels().add(model.get());
        }
    }
}
