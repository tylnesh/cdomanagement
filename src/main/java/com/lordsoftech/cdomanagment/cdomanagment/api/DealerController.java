package com.lordsoftech.cdomanagment.cdomanagment.api;

import java.util.List;

import com.lordsoftech.cdomanagment.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.cdomanagment.repository.DealerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class DealerController {

    @Autowired
    private DealerRepository repo;

    @GetMapping("/all")
    public List<Dealer> getAll() {
        return repo.findAll();
    }

}
