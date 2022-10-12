package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Dealer;
import java.util.List;

public interface DealerService {
    Dealer saveDealer(Dealer dealer);
    Dealer getDealer(String dealer);
    Dealer getDealer(Long id);
    List<Dealer> getDealers();
}
