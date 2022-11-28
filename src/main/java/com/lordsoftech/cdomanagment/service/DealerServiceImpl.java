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

    @Override
    public DealerList getDealers() {
        return null;
    }

    @Override
    public Integer updateDealers(DealerList updated) {
        List<Dealer> dbDomain = new ArrayList<>();
        updated.getList().forEach((updatedDealer) -> {
                dbDomain.add(getDealer(updatedDealer.getId()));
                dbDomain.get(dbDomain.size()-1).update(updatedDealer);
        });

        repository.saveAll(dbDomain);
        return updated.getList().size();
    };

    @Override
    public Integer deleteDealers(DealerList deleted) {
        List<Dealer> dbDomain = new ArrayList<>();
        deleted.getList().forEach((deletedDealer) -> {
            dbDomain.add(getDealer(deletedDealer.getId()));
        });
        repository.deleteAll(dbDomain);
        return dbDomain.size();
    };

    @Override
    public List<Dealer> searchDealers(Dealer searched) {
        return repository.findDealersByDealerContainingIgnoreCaseOrSlugContainingIgnoreCase(searched.getDealer(), searched.getSlug());
    }
}
