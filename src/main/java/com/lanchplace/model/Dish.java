package com.lanchplace.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dish extends AbstractBaseEntity {

    private Integer id;
    private  String restaurant;
    private  String description;
    private  Double price;
    private LocalDate date;


    public Dish(Integer id, String restaurant,String description, Double price, LocalDate date) {
        super(id);
        this.restaurant = restaurant;
        this.description = description;
        this.price = price;
        this.date=date;
    }

    public Dish(String restaurant, String description, Double price, LocalDate date) {
        this(null, restaurant, description, price, date);
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
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
                "id=" + id +
                ", restaurant=" + restaurant +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
