package com.bl.hms;

import java.util.HashSet;
import java.util.Set;

public class AppointmentRepo {
    private static AppointmentRepo instance;
    HashSet<Appointment> appointmentSet = new HashSet<>();
    UserInterface userInterface = UserInterface.getInstance();

    AppointmentRepo(){
    }

    public static synchronized AppointmentRepo getInstance(){
        if ( instance == null){
            instance = new AppointmentRepo();
        }
        return instance;
    }

    void addAppointment() {
        Appointment appointment = userInterface.addAppointment();
        appointmentSet.add(appointment);
    }

    Set<Appointment> getAppointmentSet() {
        return appointmentSet;
    }
    public Appointment getAppointment(String id) {
        for (Appointment appointment : appointmentSet) {
            return appointment;
        }
        return null;
    }

    public void remove(Appointment appointment) {
        appointmentSet.remove(appointment);
    }

    public void printAllAppointment(Set appointmentSet) {
        for (Object appointment : appointmentSet) {
            System.out.println(appointment);
        }
    }
}

