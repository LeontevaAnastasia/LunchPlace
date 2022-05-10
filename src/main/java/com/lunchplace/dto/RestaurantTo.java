package com.lunchplace.dto;

import com.lunchplace.model.AbstractBaseEntity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


public class RestaurantTo extends AbstractBaseEntity implements  Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    Integer id;
    private  String name;

    private  Long votesCounter;

    public RestaurantTo(){

    }

    public RestaurantTo(Integer id, String name, Long votesCounter) {
        super(id);
        this.name = name;
        this.votesCounter = votesCounter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantTo restaurantTo = (RestaurantTo) o;
        return votesCounter == restaurantTo.votesCounter &&
                Objects.equals(name, restaurantTo.name) &&
                Objects.equals(id, restaurantTo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, votesCounter);
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", votesCounter=" + votesCounter +
                '}';
    }
}
