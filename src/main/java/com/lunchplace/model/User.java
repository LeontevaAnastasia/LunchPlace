package com.lunchplace.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;


@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}, name = "users_unique_email_idx")})
public class User extends AbstractNamedEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 25)
    String name;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank
    @Email
    @Size(max = 100)
    String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 4, max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    @Column(name = "created", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    LocalDate registration;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    Boolean enabled;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique_idx")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public boolean isEnabled() {
        return enabled;
    }
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }
    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Transient
    private LocalDateTime voteTime;

    public User(){

    }

    public User(User u) {
        this(u.id, u.name, u.email, u.password, u.registration, u.enabled, u.roles);
    }

    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
        this(id, name, email, password, LocalDate.now(), true, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String password, LocalDate registration,  Boolean enabled, Collection<Role> roles) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.registration = registration;
        this.enabled = enabled;
        setRoles(roles);
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

    public LocalDate getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registration=" + registration +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", restaurantId=" + restaurantId +
                ", voteTime=" + voteTime +
                '}';
    }
}