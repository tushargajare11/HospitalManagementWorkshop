package com.bl.hms;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        int option;
        UserInterface userInterface = new UserInterface();
        do{
            option = userInterface.Menu();
            switch (option){
                case 1:
                    doctorOperation();
                    break;
                case 2:
                    patientOperation();
                    break;
                case 3:
                    appointmentOperation();
                    break;
                case 4:
                    break;
            }
        }while (option != Constant.EXIT);
    }

    static void doctorOperation(){
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = UserInterface.getInstance();
        DoctorRepo doctorRepo = DoctorRepo.getInstance();
        do {
            switch (userInterface.showDoctor()) {
                case 1: // add doctor
                    Doctor doctor = userInterface.addDoctor();
                    doctorRepo.addDoctor(doctor);
                    break;
                case 2:// update doctor
                    System.out.println("Enter Doctor Id ");
                    String formUser = scanner.nextLine();
                    Doctor updateDoctor = doctorRepo.getDoctor(formUser);
                    if (updateDoctor != null) {
                        userInterface.updateDoctorDetails(updateDoctor);
                    } else {
                        System.out.println("Doctor is not available");
                    }
                    break;
                case 3: // remove doctor
                    System.out.println("Enter Doctor Id ");
                    String doctorId = scanner.nextLine();
                    Doctor doctorRemove = doctorRepo.getDoctor(doctorId);
                    doctorRepo.remove(doctorRemove);
                    break;
                case 4: // print doctor list
                    Set doctorSet = doctorRepo.getDoctorSet();
                    doctorRepo.printAllDoctor(doctorSet);
                    break;
                default:
                    System.out.println("Wrong Option..!");
                    break;
            }
        }while (userInterface.showDoctor() != Constant.DOCTOREXIT) ;
    }

    static void patientOperation(){
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = UserInterface.getInstance();
        PatientRepo patientRepo = PatientRepo.getInstance();
        do {
            switch (userInterface.showPatient()) {
                case 1: // add patient
                    patientRepo.addPatient();
                    break;
                case 2: //update patient
                    System.out.println("Enter patient id");
                    String patientID = scanner.next();
                    Patient updatePatient = patientRepo.getPatient(patientID);
                    if (updatePatient != null) {
                        userInterface.updatePatientDetails(updatePatient);
                    } else {
                        System.out.println("Enter correct id");
                    }
                    break;
                case 3: // remove patient
                    System.out.println("Enter patient Id ");
                    String patientId = scanner.nextLine();
                    Patient patientRemove = patientRepo.getPatient(patientId);
                    patientRepo.remove(patientRemove);
                    break;
                case 4: // print patient list
                    Set lstPatient = patientRepo.getPatientSet();
                    patientRepo.printAllPatient(lstPatient);
                    break;
                case Constant.PATIENTEXIT:
                    break;
                default:
                    System.out.println("Wrong Option..!");
                    break;
            }
        }while (userInterface.showPatient() != Constant.PATIENTEXIT );
    }

    static void appointmentOperation(){
        Scanner scanner = new Scanner(System.in);
        AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();
        UserInterface userInterface = UserInterface.getInstance();
        do{
            switch (userInterface.showAppointment()) {
                case 1: // add appointment
                    appointmentRepo.addAppointment();
                    break;
                case 2: // update appointment
                    System.out.println("Enter appointment id");
                    String appointmentId = scanner.next();
                    Appointment updateAppointment = appointmentRepo.getAppointment(appointmentId);
                    if (updateAppointment != null ){
                        userInterface.updateAppointmentDetails(updateAppointment);
                    } else {
                        System.out.println("Enter correct id");
                    }
                    break;
                case 3: // remove appointment
                    System.out.println("Enter Appointment Id");
                    String appointmentID = scanner.next();
                    Appointment appointment = appointmentRepo.getAppointment(appointmentID);
                    appointmentRepo.remove(appointment);
                    break;
                case 4: // print appointment list
                    Set listAppointment = appointmentRepo.getAppointmentSet();
                    appointmentRepo.printAllAppointment(listAppointment);
                    break;
                case Constant.APPOINTMENTEXIT:
                    break;
                default:
                    System.out.println("Wrong Option..!");
                    break;
            }
        }while (userInterface.showAppointment() != Constant.APPOINTMENTEXIT);
    }
}




