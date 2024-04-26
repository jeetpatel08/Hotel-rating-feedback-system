package com.hotelservice.hotelmicroservice.controller;

import org.springframework.web.bind.annotation.RestController;
import com.hotelservice.hotelmicroservice.entity.Hotel;

import com.hotelservice.hotelmicroservice.service.HotelService;

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
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok().body(hotelService.getAllHotels());
    }

    @PostMapping
    public ResponseEntity<Hotel> insertHotel(@RequestBody Hotel hotel) {
        Hotel h = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(h);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Optional<Hotel>> gethotelbyid(@PathVariable String hotelId) {
        return ResponseEntity.ok().body(hotelService.getByHotelId(hotelId));
    }

}
