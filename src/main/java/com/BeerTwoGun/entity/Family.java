package com.BeerTwoGun.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "family")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    @JoinColumn(name = "family_head_1_id")
    Individual familyHead1Id;

    @OneToOne
    @JoinColumn(name = "family_head_2_id")
    Individual familyHead2Id;

    @Column(name = "family_name")
    String familyName;

    @Column(name = "family_description")
    String familyDescription;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "family_date_start")
    LocalDate familyDateStart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "family_date_end")
    LocalDate familyDateEnd;

    @Column(name = "family_notes_text")
    String familyNotesText;


}
