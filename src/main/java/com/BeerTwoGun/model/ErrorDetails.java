package com.BeerTwoGun.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ErrorDetails {
    Date timestamp;
     String message;
     String details;
}
