package com.group9.kurbani_cattle_hut_management_system.Joy.Class;

import java.io.Serializable;
import java.time.LocalDate;

public class Vaccination implements Serializable {

    private String animalId;
    private String vaccineName;
    private int doseNumber;
    private LocalDate vaccinationDate;
    private LocalDate nextDueDate;

    public Vaccination(String animalId, String vaccineName, int doseNumber, LocalDate vaccinationDate, LocalDate nextDueDate) {
        this.animalId = animalId;
        this.vaccineName = vaccineName;
        this.doseNumber = doseNumber;
        this.vaccinationDate = vaccinationDate;
        this.nextDueDate = nextDueDate;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public int getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(int doseNumber) {
        this.doseNumber = doseNumber;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(LocalDate nextDueDate) {
        this.nextDueDate = nextDueDate;
    }


    @Override
    public String toString() {
        return "Vaccination{" +
                "animalId='" + animalId + '\'' +
                ", vaccineName='" + vaccineName + '\'' +
                ", doseNumber=" + doseNumber +
                ", vaccinationDate=" + vaccinationDate +
                ", nextDueDate=" + nextDueDate +
                '}';
    }
}
