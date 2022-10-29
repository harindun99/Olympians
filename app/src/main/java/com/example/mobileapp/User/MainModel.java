package com.example.mobileapp.User;

public class MainModel {
    String name, review, email, iurl;

    MainModel()
    {

    }

    public MainModel(String name, String review, String email, String iurl) {
        this.name = name;
        this.review = review;
        this.email = email;
        this.iurl = iurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIurl() {
        return iurl;
    }

    public void setIurl(String iurl) {
        this.iurl = iurl;
    }
}
