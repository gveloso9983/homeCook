package com.example.homecookBackend.classes;

import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.client.Client;

import java.util.Date;

public class MyUser {

    public String email;

    public int id;

    public String firstName;

    public String lastName;

    public String phoneNumber;

    public java.util.Date birthDate;

    public MyUser (){

    }
    public MyUser(String newEmail, String newFirstName, String newLastName, String newPhoneNumber, java.util.Date newBirthDate, int newId) {
        email = newEmail;
        firstName = newFirstName;
        lastName = newLastName;
        phoneNumber = newPhoneNumber;
        birthDate = newBirthDate;
        id= newId;

    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }




}
