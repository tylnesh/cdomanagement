package com.lordsoftech.cdomanagment.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;
import com.lordsoftech.cdomanagment.model.GenericEntity;
import com.lordsoftech.cdomanagment.repository.GenericRepository;

public abstract class GenericController<T extends GenericEntity<T>> {

    private final GenericService<T> service;

    public GenericController(GenericRepository<T> repository) {
        this.service = new GenericService<T>(repository) {
        };
    }

    @GetMapping("")
    public ResponseEntity<Page<T>> getPage(Pageable pageable) {
        return ResponseEntity.ok(service.getPage(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getOne(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("")
    public ResponseEntity<T> update(@RequestBody @Valid T updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.update(updated));
    }

    @PostMapping(path = "/put", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> create(@RequestBody @Valid T created) {
        return ResponseEntity.ok(service.create(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.ok("Ok");
    }
}