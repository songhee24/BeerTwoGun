package com.BeerTwoGun.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parent")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "individual_parents",
            joinColumns = @JoinColumn(name = "individual_parent_id"),
            inverseJoinColumns = @JoinColumn(name = "individual_id"))
    Set<Individual> individualParents;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "individual_children",
            joinColumns = @JoinColumn(name = "individual_child_id"),
            inverseJoinColumns = @JoinColumn(name = "individual_id"))
    Set<Individual> individualChild;

    @Column(name = "parent_type")
    String parent_type;
}
