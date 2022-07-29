package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealerServiceImpl implements DealerService {

    private final DealerRepository repository;

    @Override
    public Dealer saveDealer(Dealer dealer) {
        return repository.save(dealer);
    }

    @Override
    public Dealer getDealer(String dealer) {
        Dealer dealerObject = repository.findByDealer(dealer);
        return dealerObject;
    }

    @Override
    public List<Dealer> getDealers() {
        return null;
    }
}
