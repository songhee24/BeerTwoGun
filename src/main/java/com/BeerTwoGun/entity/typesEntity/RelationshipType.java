package com.BeerTwoGun.entity.typesEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "relation_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RelationshipType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "relationship_type_name")
    String relationshipTypeName;

    @Column(name = "relationship_type_note")
    String relationshipTypeNote;
}
