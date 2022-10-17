package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Printer;
import com.lordsoftech.cdomanagment.repository.PrinterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
