package com.BeerTwoGun.entity.typesEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "occupation_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OccupationType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "profession_name")
    String professionName;

    @Column(name = "profession_description")
    String professionDescription;

    @Column(name = "profession_note")
    String professionNote;
}
