package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Payment;
import com.lordsoftech.cdomanagment.model.PaymentList;

public interface PaymentService {
    Payment savePayment(Payment payment);
    Payment getPayment(Long id);
    Integer updatePayments(PaymentList updated);
    Integer deletePayments (PaymentList deleted);

    PaymentList searchPayments (Payment searched);

}

