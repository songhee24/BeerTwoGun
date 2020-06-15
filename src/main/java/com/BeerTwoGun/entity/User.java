package com.BeerTwoGun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @Column(name = "user_name")
    String userName;

    @NotNull
    @Column(name = "email")
    String email;

    @NotNull
    @Column(name = "password")
    String password;
    @NotNull
    @Column(name = "confirm_password")
    String confirmPassword;

    // TODO вспомнить зачем я это сюда добавлял
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Collection<Role> roles;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "tree_id")
    Tree treeId;
}
