package com.lanchplace.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

@Getter
@Setter
@NoArgsConstructor
@ToString
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

    @Column(name = "created", nullable = false)
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

    public User(User u) {
        this(u.id, u.name, u.email, u.password, u.registration, u.restaurantId, u.voteTime, u.enabled, u.roles);
    }

    public User(Integer id, String name, String email, String password, Integer restaurantId, Role role, Role... roles) {
        this(id, name, email, password, LocalDate.now(), restaurantId, LocalDateTime.now(), true, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String password, LocalDate registration, Integer restaurantId, LocalDateTime voteTime, Boolean enabled, Collection<Role> roles) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.registration = registration;
        this.restaurantId = restaurantId;
        this.voteTime = voteTime;
        this.enabled = enabled;
        setRoles(roles);
    }


}