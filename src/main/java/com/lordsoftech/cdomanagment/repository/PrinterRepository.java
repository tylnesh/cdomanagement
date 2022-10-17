package com.lordsoftech.cdomanagment.repository;
import com.lordsoftech.cdomanagment.model.Printer;

public interface PrinterRepository extends GenericRepository<Printer>{

    Printer findByPrinter(String printer);

}
