package com.bl.hms;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepo {
    List appointmentList = new ArrayList();

    public void add(Appointment appointment) {
        appointmentList.add(appointment);
    }
}