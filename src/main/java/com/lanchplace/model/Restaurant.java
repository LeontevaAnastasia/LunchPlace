package com.lanchplace.model;

import java.util.List;

public class Restaurant {

    private String name;



    private List <Vote> votes;
    private List<Dish> dishes;

    public Restaurant() {

    }
    public Restaurant(String name, List<Dish> dishes, List <Vote> votes) {
        this.name = name;
        this.dishes = dishes;
        this.votes=votes;
    }
    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", vote=" + votes +
                '}';
    }
}
