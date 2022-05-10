package com.lunchplace.dto;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class VoteTo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private int restaurantId;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public VoteTo(){

    }
    public VoteTo(@NotNull int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "restaurantId=" + restaurantId +
                '}';
    }
}
