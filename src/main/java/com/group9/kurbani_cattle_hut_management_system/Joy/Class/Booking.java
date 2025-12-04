package com.group9.kurbani_cattle_hut_management_system.Joy.Class;

import java.io.Serializable;
import java.time.LocalDate;

public class Booking implements Serializable {
    private String bookingID;
    private String ownerName;
    private int paymentAmount;
    private LocalDate bookingDate;
    private String assignedTent;
    private String paymentStatus;

    public Booking(String bookingID, String ownerName, int paymentAmount, LocalDate bookingDate, String assignedTent, String paymentStatus) {
        this.bookingID = bookingID;
        this.ownerName = ownerName;
        this.paymentAmount = paymentAmount;
        this.bookingDate = bookingDate;
        this.assignedTent = assignedTent;
        this.paymentStatus = paymentStatus;
    }


    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getAssignedTent() {
        return assignedTent;
    }

    public void setAssignedTent(String assignedTent) {
        this.assignedTent = assignedTent;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", bookingDate=" + bookingDate +
                ", assignedTent='" + assignedTent + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}

