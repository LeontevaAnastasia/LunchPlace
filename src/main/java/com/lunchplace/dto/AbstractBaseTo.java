package com.lunchplace.dto;


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
