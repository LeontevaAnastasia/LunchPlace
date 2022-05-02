package com.lanchplace.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
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

    public Menu(Restaurant restaurant) {
        this(null, LocalDate.now(), null, restaurant);
    }

    public Menu(Integer id, @NotNull LocalDate date, List<Dish> dishes, Restaurant restaurant) {
        super(id);
        this.date = date;
        this.dishes = dishes;
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
