package com.group9.kurbani_cattle_hut_management_system.Joy.Class;

import java.io.Serializable;
import java.time.LocalDate;

public class Treatment implements Serializable {
    private String diagnosis;
    private String medication;
    private String dosage;
    private String dosageTime;
    private String dosageDays;
    private LocalDate durationStart;
    private LocalDate durationEnd;
    private LocalDate newVisitDate;
    private String expectedRecovery;
    private String updateStatus;

    public Treatment(String diagnosis, String medication, String dosage, String dosageTime, String dosageDays, LocalDate durationStart, LocalDate durationEnd, LocalDate newVisitDate, String expectedRecovery, String updateStatus) {
        this.diagnosis = diagnosis;
        this.medication = medication;
        this.dosage = dosage;
        this.dosageTime = dosageTime;
        this.dosageDays = dosageDays;
        this.durationStart = durationStart;
        this.durationEnd = durationEnd;
        this.newVisitDate = newVisitDate;
        this.expectedRecovery = expectedRecovery;
        this.updateStatus = updateStatus;
    }


    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDosageTime() {
        return dosageTime;
    }

    public void setDosageTime(String dosageTime) {
        this.dosageTime = dosageTime;
    }

    public String getDosageDays() {
        return dosageDays;
    }

    public void setDosageDays(String dosageDays) {
        this.dosageDays = dosageDays;
    }

    public LocalDate getDurationStart() {
        return durationStart;
    }

    public void setDurationStart(LocalDate durationStart) {
        this.durationStart = durationStart;
    }

    public LocalDate getDurationEnd() {
        return durationEnd;
    }

    public void setDurationEnd(LocalDate durationEnd) {
        this.durationEnd = durationEnd;
    }

    public LocalDate getNewVisitDate() {
        return newVisitDate;
    }

    public void setNewVisitDate(LocalDate newVisitDate) {
        this.newVisitDate = newVisitDate;
    }

    public String getExpectedRecovery() {
        return expectedRecovery;
    }

    public void setExpectedRecovery(String expectedRecovery) {
        this.expectedRecovery = expectedRecovery;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }


    @Override
    public String toString() {
        return "Treatment{" +
                "diagnosis='" + diagnosis + '\'' +
                ", medication='" + medication + '\'' +
                ", dosage='" + dosage + '\'' +
                ", dosageTime='" + dosageTime + '\'' +
                ", dosageDays='" + dosageDays + '\'' +
                ", durationStart=" + durationStart +
                ", durationEnd=" + durationEnd +
                ", newVisitDate=" + newVisitDate +
                ", expectedRecovery='" + expectedRecovery + '\'' +
                ", updateStatus='" + updateStatus + '\'' +
                '}';
    }

    public String getAnimalID() {
        return null;
    }
}

