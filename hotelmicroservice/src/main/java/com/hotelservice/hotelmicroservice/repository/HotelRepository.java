package com.hotelservice.hotelmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelservice.hotelmicroservice.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
