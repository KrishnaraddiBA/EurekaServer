package com.rating.RatingService.repository;

import com.rating.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {
    List<Rating> findByUserRating(String userRating);

    List<Rating> findByHotelRating(String hotelRating);

    Rating findByUserRatingAndHotelRating(String userRating, String hotelRating);
}


