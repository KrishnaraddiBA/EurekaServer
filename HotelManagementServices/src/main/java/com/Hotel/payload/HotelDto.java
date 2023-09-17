package com.Hotel.payload;

public class HotelDto {
    private String hotelName;
    private String location;


    public HotelDto(String hotelName, String location) {
        this.hotelName = hotelName;
        this.location = location;
    }
    public HotelDto(){

    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
