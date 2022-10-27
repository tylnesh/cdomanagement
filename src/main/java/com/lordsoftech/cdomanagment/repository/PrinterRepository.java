package com.lordsoftech.cdomanagment.repository;
import com.lordsoftech.cdomanagment.model.Printer;
import com.lordsoftech.cdomanagment.model.PrinterList;

import java.util.List;

public interface PrinterRepository extends GenericRepository<Printer>{

    Printer findByPrinter(String printer);
    List<Printer> findAllByPrinter(String printer);

}
