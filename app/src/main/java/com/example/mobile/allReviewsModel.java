package com.example.mobile;

public class allReviewsModel {

    String name,email,review,rurl;

    allReviewsModel()
    {

    }

    public allReviewsModel(String name, String email, String review, String rurl) {
        this.name = name;
        this.email = email;
        this.review = review;
        this.rurl = rurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRurl() {
        return rurl;
    }

    public void setRurl(String rurl) {
        this.rurl = rurl;
    }
}
