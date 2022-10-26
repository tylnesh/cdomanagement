package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Model;
import com.lordsoftech.cdomanagment.model.ModelList;

import java.util.List;

public interface ModelService {

    Model saveModel(Model model);
    Model getModel(Long id);
    Integer updateModels(ModelList updated);
    Integer deleteModels(ModelList deleted);
    List<Model> searchModels(Model searched);


}
