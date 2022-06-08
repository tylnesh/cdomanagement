package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.Dealer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends GenericRepository<Dealer> {
}
