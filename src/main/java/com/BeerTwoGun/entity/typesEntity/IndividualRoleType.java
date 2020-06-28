package com.BeerTwoGun.entity.typesEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "individual_role_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IndividualRoleType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "role_type_name")
    String roleTypeName;

    @Column(name = "role_type_note")
    String roleTypeNote;
}
