package net.codejava.javaee.restaurant;

import java.time.LocalDate;

public class Employee {

    private int id;
    private String fullName;
    private LocalDate birthDate;
    private String position;


    public Employee(int id, String fullName, LocalDate birthDate, String position) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
    }

    public Employee(String fullName, LocalDate birthDate, String position) {
        super();
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
    }

    public Employee(int id) {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }



}
