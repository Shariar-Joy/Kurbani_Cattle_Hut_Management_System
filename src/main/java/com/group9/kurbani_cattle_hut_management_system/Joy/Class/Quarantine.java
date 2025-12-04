package com.group9.kurbani_cattle_hut_management_system.Joy.Class;

import java.io.Serializable;

public class Quarantine implements Serializable  {
    private String animalId;
    private String symptoms;
    private String disease;
    private String isolationTime;
    private String isolationTent;
    private String medicine;

    public Quarantine(String animalId, String symptoms, String disease, String isolationTime, String isolationTent, String medicine) {
        this.animalId = animalId;
        this.symptoms = symptoms;
        this.disease = disease;
        this.isolationTime = isolationTime;
        this.isolationTent = isolationTent;
        this.medicine = medicine;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getIsolationTime() {
        return isolationTime;
    }

    public void setIsolationTime(String isolationTime) {
        this.isolationTime = isolationTime;
    }

    public String getIsolationTent() {
        return isolationTent;
    }

    public void setIsolationTent(String isolationTent) {
        this.isolationTent = isolationTent;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "Quarantine{" +
                "animalId='" + animalId + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", disease='" + disease + '\'' +
                ", isolationTime='" + isolationTime + '\'' +
                ", isolationTent='" + isolationTent + '\'' +
                ", medicine='" + medicine + '\'' +
                '}';
    }
}

