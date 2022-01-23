package com.motostylemx.cdomanagment.dao;

import java.util.List;
import java.util.Optional;

import com.motostylemx.cdomanagment.model.Dealer;

public interface DealerDao {

    int insertDealer(Dealer dealer);
    List<Dealer> selectAllDealers();

    Optional<Dealer> selectDealerById(int id);

    int deletePerson(int id);
    int updatePerson(int id, Dealer dealer);

    
}
