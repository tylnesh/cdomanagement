package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Payment;
import com.lordsoftech.cdomanagment.model.PaymentList;

import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);
    Payment getPayment(Long id);
    Integer updatePayments(PaymentList updated);
    Integer deletePayments (PaymentList deleted);

    List<Payment> searchPayments (Payment searched);

}

