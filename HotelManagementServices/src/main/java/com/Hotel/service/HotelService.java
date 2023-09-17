package com.Hotel.service;

import com.Hotel.payload.HotelDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {


    public HotelDto saveData(HotelDto hotelDto);
    public List<HotelDto> findAllData();
    public HotelDto findByHotel(String hid);




}
