package com.Hotel.controller;

import com.Hotel.payload.HotelDto;
import com.Hotel.service.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class HotelController {
    @Autowired
    private HotelService hotelService;

@PostMapping("/v2")
    public ResponseEntity<HotelDto> saveData(@RequestBody HotelDto hotelDto){
    HotelDto hotelDto1 = hotelService.saveData(hotelDto);

return new ResponseEntity<>(hotelDto1, HttpStatus.OK);

}
@GetMapping("/v3")
public ResponseEntity<List<HotelDto>> findAllData(){
    List<HotelDto> allData = hotelService.findAllData();

return new ResponseEntity<>(allData,HttpStatus.OK);
}
@GetMapping("/v4/{hid}")
public ResponseEntity<HotelDto> findById(@PathVariable String hid){
    HotelDto byHotel = hotelService.findByHotel(hid);

    return new ResponseEntity<>(byHotel,HttpStatus.OK);
}

}
