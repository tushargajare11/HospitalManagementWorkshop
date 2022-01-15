package com.bl.hms;

import java.util.*;

public class PatientRepo {
    public static PatientRepo instance;
    HashSet <Patient> patientSet = new HashSet<>();
    UserInterface userInterface = UserInterface.getInstance();

    public static synchronized PatientRepo getInstance(){
        if( instance == null ){
            instance = new PatientRepo();
        }
        return instance;
    }
    void addPatient() {
        Patient patient = userInterface.addPatient();
        patientSet.add(patient);
    }

    Set<Patient> getPatientSet() {
        return patientSet;
    }

    public boolean isPatientAvailable(String patientId){
        for (Patient patient : patientSet){
            if( patient.patientId.equals(patientId)){
                return true;
            }
        }
        return false;
    }

    public Patient getPatient(String id) {
        for (Patient patient : patientSet) {
            if (patient.patientId.equals(id)) {
                return patient;
            }
        }
        return null;
    }

    public void remove(Patient patientRemove) {
        patientSet.remove(patientRemove);
    }

    public void printAllPatient(Set patientList) {
        for (Patient patient : patientSet) {
            System.out.println(patient);
        }
    }
}

