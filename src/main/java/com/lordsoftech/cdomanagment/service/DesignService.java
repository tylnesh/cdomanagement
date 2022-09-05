package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Design;

import java.util.List;

public interface DesignService {
    Design saveDesign(Design design);
    Design getDesign(String design);
    List<Design> getDesign();
}
