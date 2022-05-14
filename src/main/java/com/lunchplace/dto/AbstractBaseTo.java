package com.lunchplace.dto;


import com.lunchplace.model.AbstractNamedEntity;

public class AbstractBaseTo extends AbstractNamedEntity {
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
