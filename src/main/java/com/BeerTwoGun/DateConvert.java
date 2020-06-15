package com.BeerTwoGun;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConvert {
    public static LocalDate getDateFromString(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = null;
        try {
            date = LocalDate.parse(stringDate,formatter);
            System.err.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

}
