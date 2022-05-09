package com.lunchplace.dto;

import com.lunchplace.model.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class RestaurantTo extends AbstractBaseEntity implements  Serializable {
    private static final long serialVersionUID = 1L;
    Integer id;
    private  String name;

    private  Long votesCounter;

    public RestaurantTo(Integer id, String name, Long votesCounter) {
        super(id);
        this.name = name;
        this.votesCounter = votesCounter;
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



}
