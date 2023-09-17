package com.rating.RatingService.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rating {
    @Id
    private String id;
    private String userRating;
    private String hotelRating;
    private int rating;
    private String feedback;

    public Rating(String id, String userRating, String hotelRating, int rating, String feedback) {
        this.id = id;
        this.userRating = userRating;
        this.hotelRating = hotelRating;
        this.rating = rating;
        this.feedback = feedback;
    }

    public Rating(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
