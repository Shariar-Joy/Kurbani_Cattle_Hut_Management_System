package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import java.io.Serializable;
import java.time.LocalDate;

public class Visit implements Serializable {

    private String name;
    private String phoneNumber;
    private LocalDate date;
    private String time;

    public Visit(String name, String phoneNumber, LocalDate date, String time) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                '}';
    }
}