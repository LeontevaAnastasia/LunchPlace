package com.lanchplace.model;

public class Dish {

    private  Restaurant restaurant;
    private  String description;
    private  Double price;

    public Dish() {
    }

    public Dish(Restaurant restaurant,String description, Double price) {
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



}
