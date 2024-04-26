package com.micro.userservice.usermicroservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.micro.userservice.usermicroservice.entity.User;
import com.micro.userservice.usermicroservice.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getusers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user) {

        User u = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @GetMapping("/{userId}")
    // @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod =
    // "ratingHotelFallBack")
    // @Retry(name = "ratingHotelRetry", fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "rateLimiter", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable String userId) {
        Optional<User> u = userService.findByUserId(userId);
        return ResponseEntity.ok().body(u);

    }

    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex) {

        // System.out.println(ex.getMessage());
        User user = User.builder()
                .userId("123313")
                .emailAddress("tempmail@mail.com")
                .about("this is temp mail address")
                .userName("temp for circui")
                .build();
        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);

    }

}
