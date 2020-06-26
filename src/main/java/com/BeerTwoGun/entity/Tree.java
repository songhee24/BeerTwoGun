package com.BeerTwoGun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "tree")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
     Long Id;


    @OneToMany
    @JoinColumn(name = "parent_id")
    List<Person> parentId;

    @OneToMany
    @JoinColumn(name = "child_id")
    List<Person> childId;

}
