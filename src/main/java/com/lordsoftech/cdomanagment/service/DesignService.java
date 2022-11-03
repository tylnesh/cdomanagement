package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Design;
import com.lordsoftech.cdomanagment.model.Model;

import java.util.List;

public interface DesignService {
    Design saveDesign(Design design);
    Design getDesign(String design);
    List<Design> getDesign();
    void linkDesignModel(Design design, Model model);
}
