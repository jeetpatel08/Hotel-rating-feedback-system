package com.micro.userservice.usermicroservice.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.userservice.usermicroservice.Exception.ResourceNotFoundException;
import com.micro.userservice.usermicroservice.entity.Hotel;
import com.micro.userservice.usermicroservice.entity.Rating;
import com.micro.userservice.usermicroservice.entity.User;
import com.micro.userservice.usermicroservice.repository.UserRepository;
import com.micro.userservice.usermicroservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;
    private ResponseEntity<Hotel> forEntity;

    @Override
    public Optional<User> findByUserId(String userId) {

        Rating[] ratings = restTemplate.getForObject("http://RATINGMICROSERVICE/ratings/users/" + userId,
                Rating[].class);

        List<Rating> listofRatings = Arrays.stream(ratings).toList();

        List<Rating> ratingList = listofRatings.stream().map(rating -> {
            forEntity = restTemplate.getForEntity("http://localhost:8081/hotels/" + rating.getHotelId(),
                    Hotel.class);
            rating.setHotel(forEntity.getBody());
            return rating;
        }).collect(Collectors.toList());

        Optional<User> u1 = Optional.of(userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found")));

        User u = u1.get();
        u.setRatings(ratingList);
        return u1;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {

        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        return userRepository.save(user);
    }

}
