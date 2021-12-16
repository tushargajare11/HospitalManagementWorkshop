package com.bl.hms;
import java.util.Map;

public class Doctor {

    enum WeekDays{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    String name;
    String Id;
    String specialisation;
    long mobileNumber;
    String emailId;
    Map<WeekDays, String> Availability;

}
