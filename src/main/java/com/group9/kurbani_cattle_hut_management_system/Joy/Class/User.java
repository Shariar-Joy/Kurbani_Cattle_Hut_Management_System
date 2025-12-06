package com.group9.kurbani_cattle_hut_management_system.Joy.Class;

import java.io.Serializable;

public class User implements Serializable {
    private String fullName;
    private String phone;
    private String role;
    private String email ;
    private String hutAddress;
    private String password ;

    public User(String fullName, String phone, String role, String email, String hutAddress, String password) {
        this.fullName = fullName;
        this.phone = phone;
        this.role = role;
        this.email = email;
        this.hutAddress = hutAddress;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHutAddress() {
        return hutAddress;
    }

    public void setHutAddress(String hutAddress) {
        this.hutAddress = hutAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", hutAddress='" + hutAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
