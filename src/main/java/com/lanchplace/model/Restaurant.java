package com.lanchplace.model;

import java.util.List;

public class Restaurant extends AbstractBaseEntity {


    private String name;



    private Long votesCount;


    public Restaurant(Integer id, String name, Long votesCount) {
      super(id);
      this.name = name;
      this.votesCount = votesCount;
    }

    public Restaurant(String name,  Long votes) {
        this(null, name,votes);

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(Long votesCount) {
        this.votesCount = votesCount;
    }
    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                '}';
    }

}
