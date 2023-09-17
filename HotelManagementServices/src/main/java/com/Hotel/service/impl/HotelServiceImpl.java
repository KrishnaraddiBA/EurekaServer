package com.Hotel.service.impl;

import com.Hotel.entity.Hotel;
import com.Hotel.exception.ResourceNotFoundException;
import com.Hotel.payload.HotelDto;
import com.Hotel.repository.HotelRepository;
import com.Hotel.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class HotelServiceImpl implements HotelService {
  @Autowired
  private HotelRepository hotelRepository;
  @Autowired
  private ModelMapper modelMapper;
    @Override
    public HotelDto saveData(HotelDto hotelDto) {
        
        Hotel hotel=mapToEntity(hotelDto);

        hotel.setHid(UUID.randomUUID().toString());
        Hotel save = hotelRepository.save(hotel);

        HotelDto hotelDto1=mapToDto(save);

        return hotelDto1;
    }

    private HotelDto mapToDto(Hotel save) {

        HotelDto map = modelMapper.map(save, HotelDto.class);
return map;
    }

    private Hotel mapToEntity(HotelDto hotelDto) {
        Hotel map = modelMapper.map(hotelDto, Hotel.class);
return map;
    }

    @Override
    public List<HotelDto> findAllData() {

        List<Hotel> all = hotelRepository.findAll();

        List<HotelDto> collect = all.stream().map(s -> mapToDto(s)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public HotelDto findByHotel(String hid) {

        Hotel hotel = hotelRepository.findById(hid).orElseThrow(() -> new ResourceNotFoundException("id not found with details!!" + hid));
        HotelDto hotelDto = mapToDto(hotel);
        return hotelDto;
    }


}
