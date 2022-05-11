package com.lunchplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "restaurant", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "restaurant_unique_name_idx")})
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @Column(name = "vote_counter")
    Long votesCounter;


    public Restaurant(){

    }
    public Restaurant(String name) {
        super(null);
        this.name = name;
        this.votesCounter = 0L;
    }

    public Restaurant(Integer id, String name) {
        super(id);
        this.name = name;
        this.votesCounter = 0L;
    }

    public Restaurant(String name, Long votesCounter) {
        this.name = name;
        this.votesCounter = votesCounter;
    }

    public Restaurant(Integer id, String name, Long votesCounter) {
        super(id);
        this.name = name;
        this.votesCounter = votesCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVotesCounter() {
        return votesCounter;
    }

    public void setVotesCounter(Long votesCounter) {
        this.votesCounter = votesCounter;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
