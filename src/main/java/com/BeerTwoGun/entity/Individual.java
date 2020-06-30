package com.BeerTwoGun.entity;

import com.BeerTwoGun.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "individual")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Individual {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Please provide a first name")
    @Size(min = 5, message="Name should have atleast 5 characters")
    @Column(name = "name_first")
    String nameFirst;

    @NotEmpty(message = "Please provide a last name")
    @Size(min = 5, message="Name should have atleast 5 characters")
    @Column(name = "name_last")
    String nameLast;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "date_birth")
    LocalDate dateBirth;

//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_death")
    LocalDate dateDeath;


    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "place_birth")
    String placeBirth;

    @Column(name = "place_death")
    String placeDeath;

    @Column(name = "cause_death")
    String causeDeath;

    @Column(name = "individual_notes")
    String text;

}
