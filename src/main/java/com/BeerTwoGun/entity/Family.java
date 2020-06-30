package com.BeerTwoGun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @NotEmpty(message = "Please provide a family Name")
    @Size(min = 2, message="family Name should have atleast 5 characters")
    @Column(name = "family_name")
    String familyName;

    @NotEmpty(message = "Please provide a description")
    @Size(min = 2, max = 50)
    @Column(name = "family_description")
    String familyDescription;

//    @DateTimeFormat(pattern="yyyy-MM-dd")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "family_date_start")
    LocalDate familyDateStart;

//    @DateTimeFormat(pattern="yyyy-MM-dd")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "family_date_end")
    LocalDate familyDateEnd;

    @Column(name = "family_notes_text")
    String familyNotesText;


}
