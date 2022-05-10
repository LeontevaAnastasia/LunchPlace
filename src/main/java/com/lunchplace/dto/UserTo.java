package com.lunchplace.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;


public class UserTo extends AbstractBaseTo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String name;



    @NotEmpty
    @Email
    private String email;

    private Integer restaurantId;

    @NotNull
    @Size(min = 5, max = 100)
    private String password;

    public UserTo(){

    }

    public UserTo(Integer id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", restaurantId=" + restaurantId +
                ", password='" + password + '\'' +
                '}';
    }
}
