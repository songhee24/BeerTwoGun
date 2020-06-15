package com.BeerTwoGun.entity;

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
    @Column(name = "id", nullable = false, unique = true)
    private Long Id;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "family_members")
    List<FamilyMember> familyMembers;

    @OneToOne
    @JoinColumn(name = "person")
    Person person;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    Tree tree;

}
