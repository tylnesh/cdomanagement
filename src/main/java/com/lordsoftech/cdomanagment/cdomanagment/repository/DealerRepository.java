package com.lordsoftech.cdomanagment.cdomanagment.repository;

import com.lordsoftech.cdomanagment.cdomanagment.model.Dealer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {

}
