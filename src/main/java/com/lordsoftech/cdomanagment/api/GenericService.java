package com.lordsoftech.cdomanagment.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;
import com.lordsoftech.cdomanagment.model.GenericEntity;
import com.lordsoftech.cdomanagment.repository.GenericRepository;

public abstract class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public Page<T> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public T get(Long id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Transactional
    public T update(T updated) throws ResourceNotFoundException {
        T dbDomain = get(updated.getId());
        dbDomain.update(updated);

        return repository.save(dbDomain);
    }

    @Transactional
    public T create(T newDomain) {
        T dbDomain = newDomain.createNewInstance();
        return repository.save(dbDomain);
    }

    @Transactional
    public void delete(Long id) throws ResourceNotFoundException {
        // check if object with this id exists
        get(id);
        repository.deleteById(id);
    }
}