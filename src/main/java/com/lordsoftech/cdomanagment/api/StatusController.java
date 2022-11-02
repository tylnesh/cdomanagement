package com.lordsoftech.cdomanagment.api;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;
import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.model.DealerList;
import com.lordsoftech.cdomanagment.model.Status;
import com.lordsoftech.cdomanagment.model.StatusList;
import com.lordsoftech.cdomanagment.repository.StatusRepository;
import com.lordsoftech.cdomanagment.service.StatusService;
import com.lordsoftech.cdomanagment.service.StatusServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/status")
@CrossOrigin(origins = "http://localhost:3000")
public class StatusController extends GenericController<Status> {

    private final StatusService service;
    public StatusController(StatusRepository repository) {
        super(repository);
        this.service = new StatusServiceImpl(repository);
    }

    @PutMapping("/update/multi")
    public ResponseEntity<Integer> updateMulti(@RequestBody @Valid StatusList updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateStatuses(updated));
    }

    @DeleteMapping("/delete/multi")
    public ResponseEntity<Integer> deleteMulti(@RequestBody @Valid StatusList deleted) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.deleteStatuses(deleted));
    }

    @PostMapping("/search")
    public ResponseEntity<StatusList> getSearchPage(@RequestBody @Valid Status searched) {
        return ResponseEntity.ok(service.searchStatuses(searched));
    }
}
