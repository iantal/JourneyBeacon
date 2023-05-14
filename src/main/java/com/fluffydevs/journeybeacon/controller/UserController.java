package com.fluffydevs.journeybeacon.controller;

import com.fluffydevs.journeybeacon.model.*;
import com.fluffydevs.journeybeacon.model.dto.PaymentDetails;
import com.fluffydevs.journeybeacon.model.dto.UserDetails;
import com.fluffydevs.journeybeacon.model.dto.UserInfo;
import com.fluffydevs.journeybeacon.repository.PaymentRepository;
import com.fluffydevs.journeybeacon.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private final UserRepository users;
    private final PaymentRepository payments;

    public UserController(UserRepository userRepository, PaymentRepository payments) {
        this.users = userRepository;
        this.payments = payments;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes="application/json")
    public ResponseEntity<Response> login(@RequestBody Users users) {
        if (users == null) {
            return ResponseEntity.badRequest().body(new ResponseError());
        }
        List<Users> usersList = this.users.findByEmail(users.getEmail());
        if (usersList.size() == 0) {
            this.users.save(users);
        }
        return ResponseEntity.ok(new ResponseOk());
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> getUsers() {
        Iterable<Users> all = users.findAll();

        List<UserInfo> details = new ArrayList<>();
        for (Users users : all) {
            details.add(new UserInfo(users.getDisplayName(), users.getUserId()));
        }

        return ResponseEntity.ok(details);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDetails> getPaymentsForUser(@PathVariable String id) {
        List<Users> userList = users.findByUserId(id);
        if (userList.size() != 1) {
            LOG.warn("Duplicate users by id {}", id);
            return ResponseEntity.internalServerError().build();
        }
        Users user = userList.get(0);

        List<Payments> paymentsList = payments.findByUserId(user.getUserId());
        List<PaymentDetails> paymentDetailsList = new ArrayList<>();
        paymentsList.forEach(i -> paymentDetailsList.add(new PaymentDetails(i.getTimestmp(), i.getAmount(),i.getRoute())));

        return ResponseEntity.ok(new UserDetails(user.getDisplayName(), paymentDetailsList));
    }
}
