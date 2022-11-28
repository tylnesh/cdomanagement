package com.lordsoftech.cdomanagment.repository;
import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.model.DealerList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealerRepository extends GenericRepository<Dealer> {
    Dealer findByDealer(String dealer);
    Dealer findBySlug(String slug);
    List<Dealer> findDealersByDealerContainingIgnoreCaseOrSlugContainingIgnoreCase(String dealer, String slug);
}
