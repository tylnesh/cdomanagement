package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.Payment;
import com.lordsoftech.cdomanagment.model.PaymentList;
import com.lordsoftech.cdomanagment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    @Override
    public Payment savePayment(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        Optional<Payment> payment = repository.findById(id);
        if (payment.isPresent()) return payment.get();
        return null;
    }

    @Override
    public Integer updatePayments(PaymentList updated) {
        List<Payment> dbDomain = new ArrayList<>();
        updated.getList().forEach((updatedItem) -> {
            dbDomain.add(getPayment(updatedItem.getId()));
            dbDomain.get(dbDomain.size()-1).update(updatedItem);
        });
        repository.saveAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public Integer deletePayments(PaymentList deleted) {
        List<Payment> dbDomain = new ArrayList<>();
        deleted.getList().forEach((deletedItem) -> {
            dbDomain.add(getPayment(deletedItem.getId()));
        });
        repository.deleteAll(dbDomain);
        return dbDomain.size();
    }

    @Override
    public List<Payment> searchPayments(Payment searched) {

        return repository.findAllByPaymentTypeContainingIgnoreCase(searched.getPaymentType());
    }


}
