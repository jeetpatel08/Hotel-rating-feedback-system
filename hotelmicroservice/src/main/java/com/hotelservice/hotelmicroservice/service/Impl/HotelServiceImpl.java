package com.hotelservice.hotelmicroservice.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.hotelmicroservice.Exception.ResourceNotFoundException;
import com.hotelservice.hotelmicroservice.entity.Hotel;
import com.hotelservice.hotelmicroservice.repository.HotelRepository;
import com.hotelservice.hotelmicroservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public Optional<Hotel> getByHotelId(String id) {
        return Optional
                .of(hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found")));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

}
