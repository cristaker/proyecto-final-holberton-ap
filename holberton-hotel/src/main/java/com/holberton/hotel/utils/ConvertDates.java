package com.holberton.hotel.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ConvertDates {
    public static LocalDate convertDateToLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
