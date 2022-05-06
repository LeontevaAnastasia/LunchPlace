package com.lanchplace.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class AbstractBaseTo {
    protected Integer id;

    public AbstractBaseTo() {
    }

    public AbstractBaseTo (Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
}
