package com.bl.hms;

import java.util.HashMap;

import java.util.Scanner;



public class Application {

    public static void main(String[] args){
        UserInterface userInterFace = new UserInterface();
        userInterFace.ShowMainMenu();
        Application application = new Application();
        int option = userInterFace.ShowMainMenu();
        application.handleUserSelection(option);
    }

    void handleUserSelection(int option){

        switch(option){
                case 1:
                    addDoctor();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;







        }

    }

    private void addDoctor() {
        Scanner sc = new Scanner(System.in);
        Doctor doctor = new Doctor();
        System.out.println("Enter the doctor ID");
        String doctorId = sc.next();
        System.out.println("Enter doctor name");
        String doctorName = sc.next();
        System.out.println("Enter doctor mobile number");
        long doctorMobileNumber = sc.nextLong();
        System.out.println("Enter the email id");
        String doctorEmailId = sc.next();
        System.out.println("Enter doctor specialisation");
        String specialisation = sc.next();

        doctor.Availability = new HashMap();
        doctor.Availability.put(Doctor.WeekDays.SUNDAY, " 10 AM to 12 PM");
        doctor.Availability.put(Doctor.WeekDays.MONDAY, " 12 AM to 2 PM");
        doctor.Availability.put(Doctor.WeekDays.TUESDAY, " 10 AM to 12 PM");
        doctor.Availability.put(Doctor.WeekDays.WEDNESDAY, " 11 AM to 3 PM");
        doctor.Availability.put(Doctor.WeekDays.THURSDAY, " 10 AM to 12 PM");
        doctor.Availability.put(Doctor.WeekDays.FRIDAY, " 10 AM to 12 PM");
        doctor.Availability.put(Doctor.WeekDays.SATURDAY, " 10 AM to 12 PM");

        DoctorRepo doctorRepo = new DoctorRepo();
        doctorRepo.add(doctor);

    }

    private void addPatient() {
        Patient patient = new Patient();
        System.out.println("enter the patient details");
        Scanner sc = new Scanner(System.in);
        patient.disease = sc.next();
        patient.Id = sc.next();
        patient.name = sc.next();
        patient.age = sc.nextInt();
        patient.emailId = sc.next();
        patient.mobileNumber = sc.nextLong();
        patient.address = sc.next();

        int option;
        option = sc.nextInt();
        switch(option){
            case 1:
                System.out.println("Male");
                break;
            case 2:
                System.out.println("Female");
                break;
            case 3:
                System.out.println("Others");
                break;
        }

        PatientRepo patientRepo = new PatientRepo();
        patientRepo.add(patient);

    }
    private void addAppointment() {
        Appointment appointment = new Appointment();
        System.out.println("enter the appointment details");
        Scanner sc = new Scanner(System.in);
        appointment.doctorId = sc.next();
        appointment.patientId = sc.next();

    }

}
