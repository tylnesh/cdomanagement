package com.lordsoftech.cdomanagment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PaymentList {
    private List<Payment> list;

}
