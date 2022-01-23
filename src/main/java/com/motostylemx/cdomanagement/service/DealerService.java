package com.motostylemx.cdomanagement.service;

import java.util.List;
import java.util.Optional;

import com.motostylemx.cdomanagement.dao.DealerDao;
import com.motostylemx.cdomanagement.model.Dealer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DealerService {

    private final DealerDao dealerDao;

    @Autowired
    public DealerService(@Qualifier("mariadb") DealerDao dealerDao) {
        this.dealerDao = dealerDao;
    }

    public int addDealer(Dealer dealer) {
        return dealerDao.insertDealer(dealer);
    }

    public List<Dealer> getAllDealers() {
        return dealerDao.selectAllDealers();
    }

    public Optional<Dealer> getDealerById(int id) {
        return dealerDao.selectDealerById(id);
    }

    public int deleteDealer(int id) {
        return dealerDao.deleteDealer(id);
    }

    public int updateDealer(int id, Dealer dealer) {
        return dealerDao.updateDealer(id, dealer);
    }

}
