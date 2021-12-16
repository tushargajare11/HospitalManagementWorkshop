package com.bl.hms;

public class Patient {

    enum Gender{
        Male, Female, Others
    }

    String name;
    int age;
    long mobileNumber;
    String Id;
    String emailId;
    String address;
    String disease;
    Gender gender;

}
