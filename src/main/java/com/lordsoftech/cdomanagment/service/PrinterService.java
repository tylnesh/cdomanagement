package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Printer;

public interface PrinterService {

    Printer savePrinter(Printer printer);
    Printer getPrinter(Long id);



}
