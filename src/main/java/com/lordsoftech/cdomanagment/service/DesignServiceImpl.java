package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Design;
import com.lordsoftech.cdomanagment.model.DesignList;
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
    public DesignList searchDesigns(Design searched) {
        List<Design> dbDomain = new ArrayList<>();
        dbDomain.addAll(designRepository.findAllByDesignContainsIgnoreCase(searched.getDesign()));
        DesignList list = new DesignList();
        list.setList(dbDomain);
        return list;
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
