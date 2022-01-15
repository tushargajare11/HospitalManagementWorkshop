package com.bl.hms;

import java.util.Objects;

public class Patient {

    enum Gender{
        MALE, FEMALE, OTHERS
    }

    String name, address, emailID, disease, patientId;
    long mobNo, age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return mobNo == patient.mobNo || Objects.equals(emailID, patient.emailID) || Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return 5;
    }

    Gender gender;

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\n' +
                ", address='" + address + '\n' +
                ", emailID='" + emailID + '\n' +
                ", disease='" + disease + '\n' +
                ", patientId='" + patientId + '\n' +
                ", mobNo=" + mobNo + '\n' +
                ", age=" + age + '\n' +
                ", info=" + gender + '\n' +
                '}';
    }
}

