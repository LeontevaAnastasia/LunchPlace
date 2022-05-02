package com.lanchplace.dto;

import com.lanchplace.model.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class RestaurantTo extends AbstractBaseEntity implements  Serializable {
    private static final long serialVersionUID = 1L;
    Integer id;
    Long votesCounter;

    public RestaurantTo(Integer id, Long votesCounter) {
        this.id=id;
        this.votesCounter = votesCounter;
    }
}
