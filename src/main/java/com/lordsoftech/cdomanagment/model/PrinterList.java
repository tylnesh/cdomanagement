package com.lordsoftech.cdomanagment.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PrinterList {
    private List<Printer> printerList;
    public PrinterList() {
        printerList = new ArrayList<>();
    }
}
