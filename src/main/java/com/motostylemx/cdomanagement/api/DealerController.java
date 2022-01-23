package com.motostylemx.cdomanagement.api;

import java.util.List;

import com.motostylemx.cdomanagement.model.Dealer;
import com.motostylemx.cdomanagement.service.DealerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RequestMapping("api/v1/dealer")
@RestController
public class DealerController {

    private final DealerService dealerService;

    @Autowired
    public DealerController(DealerService dealerService) {
        this.dealerService = dealerService;
    }

    @PostMapping
    public void addDealer(@Valid @NonNull @RequestBody Dealer dealer) {
        dealerService.addDealer(dealer);
    }

    @GetMapping
    public List<Dealer> getAllDealers() {
        return dealerService.getAllDealers();
    }

    @GetMapping(path = "{id}")
    public Dealer getDealerById(@PathVariable("id") int id) {
        return dealerService.getDealerById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDealer(@PathVariable("id") int id) {
        dealerService.deleteDealer(id);
    }

    @PutMapping(path = "{id}")
    public void updateDealer(@PathVariable("id") int id, @Valid @NonNull @RequestBody Dealer updatedDealer) {
        dealerService.updateDealer(id, updatedDealer);
    }

}
