package com.BeerTwoGun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "user_tree")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Please provide a userName")
    @Size(min = 5, message="Name should have atleast 5 characters")
    @Column(name = "user_name")
    String userName;

    @NotEmpty(message = "Please provide a email")
    @Column(name = "email")
    @Email(message = "Email should be valid")
    String email;

    @NotEmpty(message = "Please provide a password")
    @Size(min=7, message="Passport should have atleast 7 characters")
    @Column(name = "password")
    String password;

    @NotEmpty(message = "Please provide a confirm password")
    @Size(min=7, message="Passport should have atleast 7 characters")
    @Column(name = "confirm_password")
    String confirmPassword;


    // TODO вспомнить зачем я это сюда добавлял
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Collection<Role> roles;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
