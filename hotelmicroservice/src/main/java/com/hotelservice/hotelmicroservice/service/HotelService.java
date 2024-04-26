package com.hotelservice.hotelmicroservice.service;

import java.util.List;
import java.util.Optional;

import com.hotelservice.hotelmicroservice.entity.Hotel;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    Optional<Hotel> getByHotelId(String id);

    List<Hotel> getAllHotels();

}
