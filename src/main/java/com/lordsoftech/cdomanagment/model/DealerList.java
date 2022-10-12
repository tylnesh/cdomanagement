package com.lordsoftech.cdomanagment.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DealerList {
    private List<Dealer> dealerList;

    public DealerList() {
        dealerList = new ArrayList<>();
    }
}
