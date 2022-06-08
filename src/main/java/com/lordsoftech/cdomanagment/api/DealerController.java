package com.lordsoftech.cdomanagment.api;

import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.repository.DealerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dealer")
@CrossOrigin(origins = "http://localhost:3000")
public class DealerController extends GenericController<Dealer> {

    public DealerController(DealerRepository repo) {
        super(repo);
    }
}
