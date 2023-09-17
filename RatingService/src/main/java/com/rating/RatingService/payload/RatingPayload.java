package com.rating.RatingService.payload;

public class RatingPayload {
    private String userRating;
    private String hotelRating;
    private int rating;
    private String feedback;

    public RatingPayload(String userRating, String hotelRating, int rating, String feedback) {
        this.userRating = userRating;
        this.hotelRating = hotelRating;
        this.rating = rating;
        this.feedback = feedback;
    }

    public RatingPayload(){
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
