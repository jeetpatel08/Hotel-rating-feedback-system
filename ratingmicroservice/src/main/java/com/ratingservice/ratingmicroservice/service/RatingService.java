package com.ratingservice.ratingmicroservice.service;

import java.util.List;

import com.ratingservice.ratingmicroservice.entity.Rating;

public interface RatingService {
    Rating create(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
