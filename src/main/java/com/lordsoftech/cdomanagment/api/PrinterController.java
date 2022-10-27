package com.lordsoftech.cdomanagment.api;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;

import com.lordsoftech.cdomanagment.model.Model;
import com.lordsoftech.cdomanagment.model.ModelList;
import com.lordsoftech.cdomanagment.model.Printer;
import com.lordsoftech.cdomanagment.model.PrinterList;
import com.lordsoftech.cdomanagment.repository.PrinterRepository;
import com.lordsoftech.cdomanagment.service.PrinterServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/printer")
@CrossOrigin(origins = "http://localhost:3000")
public class PrinterController extends GenericController<Printer> {

    private final PrinterServiceImpl service;
    public PrinterController(PrinterRepository repo) {
        super(repo);
        this.service = new PrinterServiceImpl(repo) {
        };
    }

    @PutMapping("/update/multi")
    public ResponseEntity<Integer> updateMulti(@RequestBody @Valid PrinterList updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updatePrinters(updated));
    }

    @DeleteMapping("/delete/multi")
    public ResponseEntity<Integer> deleteMulti(@RequestBody @Valid PrinterList deleted) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.deletePrinters(deleted));
    }

    @PostMapping("/search")
    public ResponseEntity<PrinterList> getSearchPage(@RequestBody @Valid Printer searched) {
        return ResponseEntity.ok(service.searchPrinters(searched));
    }

}
