package com.bl.hms;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

public class DoctorRepo {
    public static DoctorRepo instance;
    private HashSet<Doctor> doctorSet = new HashSet<>();

    DoctorRepo() {
    }

    public static synchronized DoctorRepo getInstance() {
        if (instance == null) {
            instance = new DoctorRepo();
        }
        return instance;
    }

    void addDoctor(Doctor doctor) {
        doctorSet.add(doctor);
    }

    Set<Doctor> getDoctorSet() {
        return doctorSet;
    }

    public boolean isDoctorAvailable(String id) {//10
        //for (Doctor doctor : doctorSet){
           // if (doctor.id.equals(id)) {
               // return true;
           // }
       // }
       // return false;
        return doctorSet.stream().filter(doctor -> doctor.id.equals(id))
                .collect(Collectors.toSet()).size() > 0 ? true : false;

    }

    public Doctor getDoctor(String id) {
      //  for (Doctor doctor : doctorSet) {
           // if (doctor.id.equals(id)) {
            //    return doctor;
           // }

             return doctorSet.stream().filter(doctor -> doctor.id.equals(id)).findFirst().orElse(null);
            //return doctorSet.stream().filter(doctor -> doctor.id.equals(id)).collect(Collectors.toSet()).get(0);
        //return null;
    }


    public void remove(Doctor doctor) {
        doctorSet.remove(doctor);
    }

    public void printAllDoctor(Set doctorList) {
        //for (Doctor doctor : doctorSet) {
           // System.out.println(doctor);
       // }
        doctorSet.stream().forEach(System.out :: println);
    }
}

