package com.Hotel.payload;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ApiResponse {

    private Date date;
    private String mesage;
    private HttpStatus status;

    public ApiResponse(Date date, String mesage, HttpStatus status) {
        this.date = date;
        this.mesage = mesage;
        this.status = status;
    }

    public ApiResponse(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
