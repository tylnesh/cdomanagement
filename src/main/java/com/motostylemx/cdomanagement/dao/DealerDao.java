package com.motostylemx.cdomanagement.dao;

import java.util.List;
import java.util.Optional;

import com.motostylemx.cdomanagement.model.Dealer;

public interface DealerDao {

    int insertDealer(Dealer dealer);

    List<Dealer> selectAllDealers();

    Optional<Dealer> selectDealerById(int id);

    int deleteDealer(int id);

    int updateDealer(int id, Dealer dealer);

}
