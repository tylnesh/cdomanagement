package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.model.DealerList;
import com.lordsoftech.cdomanagment.model.Printer;
import com.lordsoftech.cdomanagment.model.PrinterList;
import com.lordsoftech.cdomanagment.repository.PrinterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrinterServiceImpl implements PrinterService {

    private final PrinterRepository repository;

    @Override
    public Printer savePrinter(Printer printer) {
        return repository.save(printer);
    }

    @Override
    public Printer getPrinter(Long id) {
        Optional<Printer> printer = repository.findById(id);
    if (printer.isPresent()) {
        return printer.get();
    } else return null;
    }

    @Override
    public Integer updatePrinters(PrinterList updated) {
        List<Printer> dbDomain = new ArrayList<>();
        updated.getPrinterList().forEach((updatedPrinter) -> {
            dbDomain.add(getPrinter(updatedPrinter.getId()));
            dbDomain.get(dbDomain.size()-1).update(updatedPrinter);
        });

        repository.saveAll(dbDomain);
        return dbDomain.size();
    };

    @Override
    public Integer deletePrinters(PrinterList deleted) {
        List<Printer> dbDomain = new ArrayList<>();
        deleted.getPrinterList().forEach((deletedPrinter) -> {
            dbDomain.add(getPrinter(deletedPrinter.getId()));
        });
        repository.deleteAll(dbDomain);
        return dbDomain.size();
    };
}
