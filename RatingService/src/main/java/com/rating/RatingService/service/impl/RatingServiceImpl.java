package com.rating.RatingService.service.impl;

import com.rating.RatingService.entity.Rating;
import com.rating.RatingService.payload.RatingPayload;
import com.rating.RatingService.repository.RatingRepository;
import com.rating.RatingService.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
   private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RatingPayload saveRating(RatingPayload ratingdto) {
Rating rating=mapToEntity(ratingdto);
        Rating save = ratingRepository.save(rating);

        RatingPayload ratingDto=mapToDto(save);


        return ratingDto;
    }

    private RatingPayload mapToDto(Rating save) {
        RatingPayload map = modelMapper.map(save, RatingPayload.class);

        return map;
    }

    private Rating mapToEntity(RatingPayload ratingdto) {
        Rating map = modelMapper.map(ratingdto, Rating.class);

        return map;
    }

    @Override
    public List<RatingPayload> findAll() {
        List<Rating> all = ratingRepository.findAll();
        List<RatingPayload> collect = all.stream().map(s -> mapToDto(s)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<RatingPayload> findByUserRating(String userRating) {

        List<Rating> byUserRating = ratingRepository.findByUserRating(userRating);
        List<RatingPayload> collect = byUserRating.stream().map(s -> mapToDto(s)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<RatingPayload> findByHotelRating(String hotelRating) {

        List<Rating> byHotelRating = ratingRepository.findByHotelRating(hotelRating);
        List<RatingPayload> collect = byHotelRating.stream().map(s -> mapToDto(s)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public RatingPayload findByPartcularUserAndHotel(String userRating, String hotelRating) {
        Rating byBothUserRatingAndHotelRating = ratingRepository.findByUserRatingAndHotelRating(userRating, hotelRating);

        RatingPayload ratingPayload = mapToDto(byBothUserRatingAndHotelRating);
        return ratingPayload;
    }
}
