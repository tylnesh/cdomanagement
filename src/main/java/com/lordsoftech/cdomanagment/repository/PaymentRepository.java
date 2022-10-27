package com.lordsoftech.cdomanagment.repository;

import com.lordsoftech.cdomanagment.model.Payment;

import java.util.List;

public interface PaymentRepository extends GenericRepository<Payment>{
    Payment findByPaymentType(String paymentType);
    List<Payment> findAllByPaymentTypeContainingIgnoreCase(String paymentType);
}
