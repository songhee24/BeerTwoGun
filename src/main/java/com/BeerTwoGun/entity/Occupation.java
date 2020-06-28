package com.BeerTwoGun.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "occupation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "occupation_individuals",
            joinColumns = @JoinColumn(name = "occupation_id"),
            inverseJoinColumns = @JoinColumn(name = "individual_id"))
    Set<Individual> individuals;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "occupations_type",
            joinColumns = @JoinColumn(name = "occupation_id"),
            inverseJoinColumns = @JoinColumn(name = "occupation_type_id"))
    Set<Occupation> occupations;
}
