package com.Hotel.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {
    @Id
    private String hid;
    private String hotelName;
    private String location;

    public Hotel(String hid, String hotelName, String location) {
        this.hid = hid;
        this.hotelName = hotelName;
        this.location = location;
    }

    public Hotel(){

    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
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
