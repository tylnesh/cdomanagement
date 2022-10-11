package com.lordsoftech.cdomanagment.api;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;
import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.repository.DealerRepository;
import com.lordsoftech.cdomanagment.service.DealerService;
import com.lordsoftech.cdomanagment.service.DealerServiceImpl;
import com.lordsoftech.cdomanagment.service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dealer")
@CrossOrigin(origins = "http://localhost:3000")
public class DealerController extends GenericController<Dealer> {

    private final DealerServiceImpl service;
    public DealerController(DealerRepository repo) {
        super(repo);
        this.service = new DealerServiceImpl(repo) {
        };
    }

    @PutMapping("/update-multi")
    public ResponseEntity<Dealer> updateMulti(@RequestBody @Valid List<Dealer> updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateMultipleDealers(updated));
    }
//    @Override
//    @PutMapping("")
//    public ResponseEntity<Dealer> update(@RequestBody @Valid Dealer updated) throws ResourceNotFoundException {
////        @Transactional
////        public T update(T updated) throws ResourceNotFoundException {
////            T dbDomain = get(updated.getId());
////            dbDomain.update(updated);
////
////            return repository.save(dbDomain);
////        }
//
//        return ResponseEntity.ok(service.update(updated));
//    }
}
