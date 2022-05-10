package com.example.drivoapp.model;

public class Car {

    private String carName;
    private String carRating;
    private String carPrice;
    private int carImage;

    public Car(String carName, String carRating, String carPrice, int carImage) {
        this.carName = carName;
        this.carRating = carRating;
        this.carPrice = carPrice;
        this.carImage = carImage;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarRating() {
        return carRating;
    }

    public void setCarRating(String carRating) {
        this.carRating = carRating;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }
}
