package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.model.DealerList;
import com.lordsoftech.cdomanagment.repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Dealer getDealer(Long id) {
        Optional<Dealer> dealer = repository.findById(id);
        if (dealer.isPresent()) {
            return dealer.get();
        } else return null;
    }

    //TODO: Implement searching by ID and updating one by one
    public int updateMultipleDealers(DealerList updated) {
//        System.out.println(updated.getDealerList().get(0));
        List<Dealer> dbDomain = new ArrayList<>();
        updated.getDealerList().forEach((updatedDealer) -> {
                dbDomain.add(getDealer(updatedDealer.getId()));
                dbDomain.get(dbDomain.size()-1).update(updatedDealer);
        });

//        List<Dealer> dbDomain = new ArrayList<>();
//        for (int i = 0; i< updated.getDealerList().size(); i++) {
//            dbDomain.add(getDealer(updated.getDealerList().get(i).getDealer()));
//            dbDomain.get(i).update(updated.getDealerList().get(i));
//        }
        repository.saveAll(dbDomain);
        return updated.getDealerList().size();

    };


    @Override
    public List<Dealer> getDealers() {
        return null;
    }
}
