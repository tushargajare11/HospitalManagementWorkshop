package com.bl.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private static UserInterface instance;
    UserInterface(){
    }

    public static UserInterface getInstance(){
        if( instance == null ){
            instance = new UserInterface();
        }
        return instance;
    }
    public int Menu(){
        System.out.println("Hospital Management System");
        System.out.println("Select \n1.Doctor\n2.Patient\n3.Appointment\n"+Constant.EXIT+".Exit");
        System.out.println("Select Your Option :");
        return scanner.nextInt();
    }
    public int showDoctor(){
        System.out.println("1.Add Doctor \n2.Update Doctor \n3.Delete Doctor\n4.Show All Doctors List\n"+Constant.DOCTOREXIT+".Exit");
        return scanner.nextInt();

    }
    public int showPatient(){
        System.out.println("1.Add Patient \n2.Update Patient \n3.Delete Patient \n4.Show All Patient list\n"+Constant.PATIENTEXIT+".Exit ");
        return scanner.nextInt();
    }
    public int showAppointment(){
        System.out.println("1.Add Appointment\n2.Update Appointment\n3.Delete Appointment\n4.Show All Appointment list\n"+Constant.APPOINTMENTEXIT+".Exit");
        return scanner.nextInt();
    }

    public Doctor addDoctor() {
        Scanner scanner = new Scanner(System.in);
        Doctor doctor = new Doctor();

        System.out.println("Enter Doctor Name :");
        doctor.docName = scanner.nextLine();

        System.out.println("Enter Doctor Specialization :");
        doctor.specialization = scanner.nextLine();

        System.out.println("Enter Doctor Email ID :");
        doctor.emailID = scanner.nextLine();

        System.out.println("Enter Doctor ID :");
        doctor.id = scanner.nextLine();

        System.out.println("Enter Doctor Mobile Name :");
        doctor.mobNo = scanner.nextLong();

        doctor.availability = new HashMap<>();
        doctor.availability.put(Doctor.WeekDays.SUNDAY,"10 AM to 12 PM");
        doctor.availability.put(Doctor.WeekDays.MONDAY,"12 PM to 2 PM");
        doctor.availability.put(Doctor.WeekDays.TUESDAY,"2 PM to 4 PM");
        doctor.availability.put(Doctor.WeekDays.WEDNESDAY,"4 PM to 6 PM");
        doctor.availability.put(Doctor.WeekDays.THURSDAY,"6 PM to 8 PM");
        doctor.availability.put(Doctor.WeekDays.FRIDAY,"8 PM to 10 PM");
        doctor.availability.put(Doctor.WeekDays.SATURDAY,"10 PM to 12 AM");

        return doctor;
    }

    Patient addPatient() {
        Scanner scanner = new Scanner(System.in);
        Patient patient = new Patient();

        System.out.println("Enter Patient Name :");
        patient.name = scanner.nextLine();

        System.out.println("Enter Patient Email ID :");
        patient.emailID = scanner.nextLine();

        System.out.println("Enter Patient Disease :");
        patient.disease = scanner.nextLine();

        System.out.println("Enter the Patient Address :");
        patient.address = scanner.nextLine();

        System.out.println("Enter the Patient ID :");
        patient.patientId = scanner.nextLine();

        System.out.println("Enter Patient Age :");
        patient.age = scanner.nextLong();

        System.out.println("Enter Patient Mobile Name :");
        patient.mobNo = scanner.nextLong();

        System.out.println("1.Male \n2.Female \n3.Others :");
        int option = scanner.nextInt();
        switch (option)
        {
            case 1:
                patient.gender = Patient.Gender.MALE;
                break;
            case 2:
                patient.gender = Patient.Gender.FEMALE;
                break;
            case 3:
                patient.gender = Patient.Gender.OTHERS;
                break;
            default:
                System.out.println("Wrong Option..!");
                break;
        }
        return patient;
    }

    Appointment addAppointment() {
        DoctorRepo doctorRepo = DoctorRepo.getInstance();
        PatientRepo patientRepo = PatientRepo.getInstance();
        Scanner scanner = new Scanner(System.in);
        Appointment appointment = new Appointment();

        System.out.println("Enter Appointment Id");
        appointment.appointmentId = scanner.next();

        System.out.println("Enter doctor id");//10
        appointment.doctorId = scanner.next();

        if (doctorRepo.isDoctorAvailable(appointment.doctorId)) {//true
            System.out.println("Enter the PatientId :");
            appointment.patientId = scanner.next();

            if(patientRepo.isPatientAvailable(appointment.patientId)) {//true
                System.out.println("Enter the RoomNumber :");
                appointment.roomNumber = scanner.nextLong();

                System.out.println("Enter the Appointment Date like dd-MMM-yyyy");
                Scanner scanner2 = new Scanner(System.in);
                appointment.appointmentDate = scanner2.next();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                try {
                    Date date = formatter.parse(appointment.appointmentDate);
                } catch (ParseException e) {
                    e.printStackTrace(); //Print Exception in Details
                }
            } else {
                System.out.println("Patient id is not available");
            }
        } else {
            System.out.println("Doctor id not available ");
        }
        return appointment;
    }

    public void updatePatientDetails(Patient updatePatient) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter what u want to update \n1.patient Name\n2.address\n3.emailID" +
                    "\n4.disease\n5.mobNo\n6.age\n7.Gender\n"+Constant.UPDATEPATIENTEXIT+".Exit");
            int numSelected = scanner.nextInt();
            switch (numSelected) {
                case 1:
                    System.out.println("Enter name");
                    updatePatient.name = scanner.next();
                    break;
                case 2:
                    System.out.println("Enter address");
                    updatePatient.address = scanner.next();
                    break;
                case 3:
                    System.out.println("Enter Email ");
                    updatePatient.emailID = scanner.next();
                    break;
                case 4:
                    System.out.println("Enter disease");
                    updatePatient.disease = scanner.next();
                    break;
                case 5:
                    System.out.println("Enter Mobile");
                    updatePatient.mobNo = scanner.nextLong();
                    break;
                case 6:
                    System.out.println("Enter age");
                    updatePatient.age = scanner.nextInt();
                    break;
                case 7:
                    System.out.println("Enter Gender");
                    System.out.println("1.Male \n2.Female \n3.Others :");
                    int option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            updatePatient.gender = Patient.Gender.MALE;
                            break;
                        case 2:
                            updatePatient.gender = Patient.Gender.FEMALE;
                            break;
                        case 3:
                            updatePatient.gender = Patient.Gender.OTHERS;
                            break;
                        default:
                            System.out.println("Wrong Option..!");
                    }
                    break;
                case Constant.UPDATEPATIENTEXIT:
                    return;
                default:
                    System.out.println("Enter correct option plz..");
                    break;
            }
        }
    }

    public void updateDoctorDetails(Doctor updateDoctor) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter what u want to update \n1.docName\n2.specialization\n3.emailID" +
                    "\n4.mobNo\n"+Constant.UPDATEDOCTOREXIT+".Exit");
            int numSelected = scanner.nextInt();
            switch (numSelected) {
                case 1:
                    System.out.println("Enter name");
                    updateDoctor.docName = scanner.next();
                    break;
                case 2:
                    System.out.println("Enter Specialist");
                    updateDoctor.specialization = scanner.next();
                    break;
                case 3:
                    System.out.println("Enter Mobile");
                    updateDoctor.mobNo = scanner.nextLong();
                    break;
                case 4:
                    System.out.println("Enter Email");
                    updateDoctor.emailID = scanner.next();
                    break;
                case Constant.UPDATEDOCTOREXIT:
                    return;
                default:
                    System.out.println("Enter correct option plz..");
                    break;
            }
        }
    }

    public void updateAppointmentDetails(Appointment updateAppointment) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter what u want to update \n1.patientId\n2.doctorId\n3.appointmentDate" +
                    "\n4.roomNumber\n"+Constant.UPDATEAPPOINTMENTEXIT+".Exit");
            int numSelected = scanner.nextInt();
            switch (numSelected) {
                case 1:
                    System.out.println("Enter patientId");
                    updateAppointment.patientId = scanner.next();
                    break;
                case 2:
                    System.out.println("Enter doctorId");
                    updateAppointment.doctorId = scanner.next();
                    break;
                case 3:
                    System.out.println("Enter the Appointment Date like dd-MMM-yyyy");
                    Scanner scanner2 = new Scanner(System.in);
                    updateAppointment.appointmentDate = scanner2.next();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                    try {
                        Date date = formatter.parse(updateAppointment.appointmentDate);
                    } catch (ParseException e) {
                        e.printStackTrace(); //Print Exception in Details
                    }
                    break;
                case 4:
                    System.out.println("Enter roomNumber");
                    updateAppointment.roomNumber = scanner.nextLong();
                    break;
                case Constant.UPDATEAPPOINTMENTEXIT:
                    System.out.println("Successfully update");
                    return;
                default:
                    System.out.println("Enter correct option plz..");
                    break;
            }
        }
    }
}

