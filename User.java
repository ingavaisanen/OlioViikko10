package com.example.userprogram;

import java.lang.String;

public class User {

    private String firstName;
    public String getFirstName() {

        return firstName;
    }
    private String lastName;
    public String getLastName() {

        return lastName;
    }
    private String email;
    public String getEmail() {

        return email;
    }
    private String degreeProgram;
    public String getDegreeProgram() {

        return degreeProgram;
    }

    private String degree;
    public String getDegree() {
        return degree;
    }

    public User(String firstName, String lastName, String email, String degreeProgram, String degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.degree = degree;
    }
    
}
