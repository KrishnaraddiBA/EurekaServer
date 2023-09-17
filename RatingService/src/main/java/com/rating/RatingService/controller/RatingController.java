package com.rating.RatingService.controller;

import com.rating.RatingService.payload.RatingPayload;
import com.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RatingController {
    @Autowired
    private RatingService ratingService;


    @PostMapping("/v2")
    public ResponseEntity<RatingPayload> saveData(@RequestBody RatingPayload ratingPayload){
        RatingPayload ratingPayload1 = ratingService.saveRating(ratingPayload);


    return new ResponseEntity<>(ratingPayload1, HttpStatus.CREATED);
    }
    @GetMapping("/v3")
    public ResponseEntity<List<RatingPayload>> findAllData(){
        List<RatingPayload> all = ratingService.findAll();
return new ResponseEntity<>(all,HttpStatus.FOUND);
    }
    @GetMapping("/v4/{userRating}")
    public ResponseEntity<List<RatingPayload>> findByUserData(@PathVariable String userRating){
        List<RatingPayload> byUserRating = ratingService.findByUserRating(userRating);
    return new ResponseEntity<>(byUserRating,HttpStatus.FOUND);

    }
    @GetMapping("/v5/{hotelRating}")
    public ResponseEntity<List<RatingPayload>> findByHotelData(@PathVariable String hotelRating){

        List<RatingPayload> byHotelRating = ratingService.findByHotelRating(hotelRating);
        return new ResponseEntity<>(byHotelRating,HttpStatus.FOUND);
    }

    @GetMapping("v6/{userRating}/{hotelRating}")
    public ResponseEntity<RatingPayload> findByBothUserAndHotel(@PathVariable String userRating,@PathVariable String hotelRating){
        RatingPayload byPartcularUserAndHotel = ratingService.findByPartcularUserAndHotel(userRating, hotelRating);

    return new ResponseEntity<>(byPartcularUserAndHotel,HttpStatus.OK);
    }





}
