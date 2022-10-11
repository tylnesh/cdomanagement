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

    //TODO: Implement searching by ID and updating one by one
    public List<Dealer> updateMultipleDealers(List<Dealer> updated) {
        List<Dealer> dbDomain;
        for (int i = 0; i< updated.size(); i++) {
//            dbDomain.add(getDealer())
        }
//     T dbDomain = get(updated.getId());
//        dbDomain.update(updated);
//
//        return repository.save(dbDomain);

        return null;
    };


    @Override
    public List<Dealer> getDealers() {
        return null;
    }
}
