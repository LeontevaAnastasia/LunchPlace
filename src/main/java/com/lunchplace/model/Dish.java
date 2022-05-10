package com.lunchplace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dish", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "menu_id"}, name = "dish_unique_menu_name_idx")})
public class Dish extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 1, max = 100)
    private  String description;

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(min = 1, max = 10000)
    private  Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Menu menu;

    public Dish(){

    }

    public Dish(String description, Double price, Menu menu) {
        this(null, description, price, menu);
    }
    public Dish(String description, Double price) {
        this(null, description, price, null);
    }
    public Dish(Integer id, String description, Double price, Menu menu) {
        super(id);
        this.description = description;
        this.price = price;
        this.menu = menu;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}
