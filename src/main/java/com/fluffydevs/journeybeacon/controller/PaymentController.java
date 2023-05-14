package com.fluffydevs.journeybeacon.controller;

import com.fluffydevs.journeybeacon.model.Payments;
import com.fluffydevs.journeybeacon.model.Response;
import com.fluffydevs.journeybeacon.model.ResponseOk;
import com.fluffydevs.journeybeacon.repository.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    private final PaymentRepository payments;

    public PaymentController(PaymentRepository paymentRepository) {
        this.payments = paymentRepository;
    }
    @PostMapping("/payments")
    public ResponseEntity<Response> pay(@RequestBody Payments payments) {
        this.payments.save(payments);
        return ResponseEntity.ok(new ResponseOk());
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payments>> getAllPayments() {
        List<Payments> list = new ArrayList<>();
        payments.findAll().forEach(list::add);
        return ResponseEntity.ok(list);
    }
}
