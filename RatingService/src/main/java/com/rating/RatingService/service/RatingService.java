package com.rating.RatingService.service;

import com.rating.RatingService.payload.RatingPayload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    public RatingPayload saveRating(RatingPayload ratingdto);
    public List<RatingPayload> findAll();
    public List<RatingPayload> findByUserRating(String userRating);

    public List<RatingPayload> findByHotelRating(String hotelRating);
    public RatingPayload findByPartcularUserAndHotel(String userRating,String hotelRating);


}
