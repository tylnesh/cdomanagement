package com.lordsoftech.cdomanagment.api;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;
import com.lordsoftech.cdomanagment.model.Design;
import com.lordsoftech.cdomanagment.model.DesignList;
import com.lordsoftech.cdomanagment.model.Model;
import com.lordsoftech.cdomanagment.model.ModelList;
import com.lordsoftech.cdomanagment.repository.DesignRepository;
import com.lordsoftech.cdomanagment.repository.ModelRepository;
import com.lordsoftech.cdomanagment.service.DesignService;
import com.lordsoftech.cdomanagment.service.DesignServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/design")
@CrossOrigin(origins = "http://localhost:3000")
public class DesignController extends GenericController<Design> {
    public final DesignService service;

    public DesignController(DesignRepository designRepository, ModelRepository modelRepository) {
        super (designRepository);
        this.service= new DesignServiceImpl(designRepository,modelRepository);
    }
    @PutMapping("/update/multi")
    public ResponseEntity<Integer> updateMulti(@RequestBody @Valid DesignList updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateDesigns(updated));
    }

    @DeleteMapping("/delete/multi")
    public ResponseEntity<Integer> deleteMulti(@RequestBody @Valid DesignList deleted) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.deleteDesigns(deleted));
    }

    @PostMapping("/search")
    public ResponseEntity<List<Design>> getSearchPage(@RequestBody @Valid Design searched) {
        return ResponseEntity.ok(service.searchDesigns(searched));
    }

}
