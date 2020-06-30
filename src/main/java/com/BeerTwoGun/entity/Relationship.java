package com.BeerTwoGun.entity;

import com.BeerTwoGun.entity.typesEntity.IndividualRoleType;
import com.BeerTwoGun.entity.typesEntity.RelationshipType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "relationship")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    @JoinColumn(name = "relationship_type_id")
    RelationshipType relationshipType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "family_relationships",
            joinColumns = @JoinColumn(name = "relationship_id"),
            inverseJoinColumns = @JoinColumn(name = "family_id"))
    Set<Family> families;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "individual_1_heads",
            joinColumns = @JoinColumn(name = "relationship_id"),
            inverseJoinColumns = @JoinColumn(name = "individual_id"))
    Set<Individual> individualHead1;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "individual_2_heads",
//            joinColumns = @JoinColumn(name = "relationship_id"),
//            inverseJoinColumns = @JoinColumn(name = "individual_id"))
//    Set<Individual> individualHead2;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "relationship_individual_head_1_roles",
            joinColumns = @JoinColumn(name = "relationship_id"),
            inverseJoinColumns = @JoinColumn(name = "role_type_id"))
    Set<IndividualRoleType> individualRoleTypes1;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "relationship_individual_head_2_roles",
//            joinColumns = @JoinColumn(name = "relationship_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_type_id"))
//    Set<IndividualRoleType> individualRoleTypes2;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "relationship_date_start")
    LocalDate relationshipDateStart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "relationship_date_end")
    LocalDate relationshipDateEnd;

    @Column(name = "relationship_note")
    String relationshipNote;



}
