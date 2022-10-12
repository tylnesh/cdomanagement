package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.AppUser;
import com.lordsoftech.cdomanagment.model.Dealer;

import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends GenericRepository<Dealer> {
    Dealer findByDealer(String dealer);
    Dealer findBySlug(String slug);
}
