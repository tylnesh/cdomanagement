package com.lordsoftech.cdomanagment.api;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;
import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.model.DealerList;
import com.lordsoftech.cdomanagment.repository.DealerRepository;
import com.lordsoftech.cdomanagment.service.DealerServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/update/multi")
    public ResponseEntity<Integer> updateMulti(@RequestBody @Valid DealerList updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateDealers(updated));
    }

    @DeleteMapping("/delete/multi")
    public ResponseEntity<Integer> deleteMulti(@RequestBody @Valid DealerList deleted) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.deleteDealers(deleted));
    }

    @PostMapping("/search")
    public ResponseEntity<List<Dealer>> getSearchPage(@RequestBody @Valid Dealer searched) {
        return ResponseEntity.ok(service.searchDealers(searched));
    }

}
