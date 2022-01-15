package com.bl.hms;

import java.util.Map;
import java.util.Objects;

public class Doctor {

    enum WeekDays{
        SUNDAY, MONDAY,TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    String docName;
    String specialization;
    String emailID;
    String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return mobNo == doctor.mobNo || Objects.equals(emailID, doctor.emailID) || Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() {
        return 5;
    }

    long mobNo;
    Map<WeekDays,String> availability;

    @Override
    public String toString() {
        return "Doctor{" +
                "docName='" + docName + '\n' +
                ", specialization='" + specialization + '\n' +
                ", emailID='" + emailID + '\n' +
                ", id='" + id + '\n' +
                ", mobNo=" + mobNo + '\n' +
                ", availability=" + availability + '\n' +
                '}';
    }
}


