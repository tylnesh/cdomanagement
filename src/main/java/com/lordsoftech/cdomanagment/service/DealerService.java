package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.model.DealerList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DealerService {
    Dealer saveDealer(Dealer dealer);
    Dealer getDealer(String dealer);
    Dealer getDealer(Long id);
    DealerList getDealers();
    Integer updateDealers(DealerList updated);
    Integer deleteDealers(DealerList deleted);
    DealerList searchDealers(Dealer searched);
}
