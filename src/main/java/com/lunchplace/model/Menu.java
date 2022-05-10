package com.lunchplace.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"rest_id", "created"}, name = "menu_unique_rest_created_idx")})
public class Menu extends AbstractBaseEntity {

    @Column(name = "created", nullable = false)
    @NotNull
    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @JsonManagedReference
    private List<Dish> dishes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id")
    private Restaurant restaurant;


    public Menu(){

    }
    public Menu(Restaurant restaurant) {
        this(null, LocalDate.now(), null, restaurant);
    }

    public Menu(Integer id, @NotNull LocalDate date, List<Dish> dishes, Restaurant restaurant) {
        super(id);
        this.date = date;
        this.dishes = dishes;
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Menu (" +
                "id=" + getId() +
                ", date=" + date +
                ", dishes=" + dishes +
                ')';
    }
}
