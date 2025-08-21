package com.completedsa.java.java8.dateTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
 * Java Date and Time
 *      Class	            Description
 *      LocalDate	        Represents a date (year, month, day (yyyy-MM-dd))
 *      LocalTime	        Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
 *      LocalDateTime	    Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
 *      DateTimeFormatter	Formatter for displaying and parsing date-time objects
 */
public class DateTimeApi {
    public static void main(String[] args) {
        // Display the current date
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        // Display the current time
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        // Display the current date and time
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = localDateTime.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);

        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate1 = localDateTime.format(myFormatObj1);
        System.out.println("After Formatting: " + formattedDate1);

        DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String formattedDate2 = localDateTime.format(myFormatObj2);
        System.out.println("After Formatting: " + formattedDate2 );

        DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate3 = localDateTime.format(myFormatObj3);
        System.out.println("After Formatting: " + formattedDate3);
    }
}
