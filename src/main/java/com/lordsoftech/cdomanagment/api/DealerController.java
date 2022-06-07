package com.lordsoftech.cdomanagment.api;

import java.util.List;

import javax.validation.Valid;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;
import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.repository.DealerRepository;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO: Maybe make into a generic controller with only differences being specified by inheritance?

@RestController
@RequestMapping("/api/v1/dealer")
@CrossOrigin(origins = "http://localhost:3000")
public class DealerController {

    @Autowired
    private DealerRepository repo;

    @GetMapping("/")
    public List<Dealer> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dealer> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        Dealer dealer = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dealer not found for this ID"));
        return ResponseEntity.ok().body(dealer);
    }

    @PostMapping("/post/")
    public Dealer create(@Valid @RequestBody Dealer dealer) {
        return repo.save(dealer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dealer> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Dealer dealerUpdate)
            throws ResourceNotFoundException {
        Dealer dealer = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dealer not found for this ID :: " + id));
        dealer.setSlug(dealerUpdate.getSlug());
        dealer.setDealer(dealerUpdate.getDealer());
        final Dealer updatedDealar = repo.save(dealer);
        return ResponseEntity.ok(updatedDealar);
    }
}
