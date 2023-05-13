package com.fluffydevs.journeybeacon.controller;

import com.fluffydevs.journeybeacon.model.Users;
import com.fluffydevs.journeybeacon.model.dto.UserDetails;
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

    public UserController(UserRepository userRepository) {
        this.users = userRepository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes="application/json")
    public ResponseEntity<String> login(@RequestBody Users users) {
        if (users == null) {
            return ResponseEntity.badRequest().body("User is null");
        }
        if (!users.isComplete()) {
            return ResponseEntity.badRequest().body("User data is incomplete");
        }
        List<Users> usersList = this.users.findByEmail(users.getEmail());
        if (usersList.size() == 0) {
            this.users.save(users);
        }
        return ResponseEntity.ok("User login successful");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDetails>> getUsers() {
        Iterable<Users> all = users.findAll();

        List<UserDetails> details = new ArrayList<>();
        for (Users users : all) {
            details.add(new UserDetails(users.getUserId()));
        }

        return ResponseEntity.ok(details);
    }
}
