package com.BeerTwoGun.entity;

import com.BeerTwoGun.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "family_member")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "member")
    String member;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "birth_date")
    LocalDate birthDate;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "inn")
    String inn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Person personId;
}
