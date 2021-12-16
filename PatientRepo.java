package com.bl.hms;

import java.util.ArrayList;
import java.util.List;

public class PatientRepo {
    List patientList = new ArrayList();

    public void add(Patient patient) {
        patientList.add(patient);

    }
}