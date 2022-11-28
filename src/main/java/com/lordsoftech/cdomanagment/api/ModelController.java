package com.lordsoftech.cdomanagment.api;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;
import com.lordsoftech.cdomanagment.model.Model;
import com.lordsoftech.cdomanagment.model.ModelList;
import com.lordsoftech.cdomanagment.repository.DealerRepository;
import com.lordsoftech.cdomanagment.repository.DesignRepository;
import com.lordsoftech.cdomanagment.repository.ModelRepository;
import com.lordsoftech.cdomanagment.service.ModelServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/model")
@CrossOrigin(origins = "http://localhost:3000")
public class ModelController extends GenericController<Model> {

    public final ModelServiceImpl service;

    public ModelController(ModelRepository modelRepository, DesignRepository designRepository) {
        super(modelRepository);
        this.service = new ModelServiceImpl(modelRepository, designRepository);
    }

    @PutMapping("/update/multi")
    public ResponseEntity<Integer> updateMulti(@RequestBody @Valid ModelList updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateModels(updated));
    }

    @DeleteMapping("/delete/multi")
    public ResponseEntity<Integer> deleteMulti(@RequestBody @Valid ModelList deleted) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.deleteModels(deleted));
    }

    @PostMapping("/search")
    public ResponseEntity<List<Model>> getSearchPage(@RequestBody @Valid Model searched) {
        return ResponseEntity.ok(service.searchModels(searched));
    }
}
