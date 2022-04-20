package com.lanchplace.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dish {

    private  Restaurant restaurant;
    private  String description;
    private  Double price;



    private LocalDate date;

    public Dish() {
    }

    public Dish(Restaurant restaurant,String description, Double price, LocalDate date) {
        this.restaurant = restaurant;
        this.description = description;
        this.price = price;
        this.date=date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "restaurant=" + restaurant +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
