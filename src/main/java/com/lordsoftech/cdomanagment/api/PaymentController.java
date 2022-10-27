package com.lordsoftech.cdomanagment.api;

import com.lordsoftech.cdomanagment.ResourceNotFoundException;
import com.lordsoftech.cdomanagment.model.Model;
import com.lordsoftech.cdomanagment.model.ModelList;
import com.lordsoftech.cdomanagment.model.Payment;
import com.lordsoftech.cdomanagment.model.PaymentList;
import com.lordsoftech.cdomanagment.repository.GenericRepository;
import com.lordsoftech.cdomanagment.repository.PaymentRepository;
import com.lordsoftech.cdomanagment.service.PaymentService;
import com.lordsoftech.cdomanagment.service.PaymentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController extends GenericController<Payment> {

    public final PaymentServiceImpl service;

    public PaymentController(PaymentRepository repository) {
        super(repository);
        this.service = new PaymentServiceImpl(repository);
    }

    @PutMapping("/update/multi")
    public ResponseEntity<Integer> updateMulti(@RequestBody @Valid PaymentList updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updatePayments(updated));
    }

    @DeleteMapping("/delete/multi")
    public ResponseEntity<Integer> deleteMulti(@RequestBody @Valid PaymentList deleted) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.deletePayments(deleted));
    }

    @PostMapping("/search")
    public ResponseEntity<PaymentList> getSearchPage(@RequestBody @Valid Payment searched) {
        return ResponseEntity.ok(service.searchPayments(searched));
    }


}
