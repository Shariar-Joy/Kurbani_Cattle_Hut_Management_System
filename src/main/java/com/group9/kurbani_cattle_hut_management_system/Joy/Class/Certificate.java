package com.group9.kurbani_cattle_hut_management_system.Joy.Class;

import java.io.Serializable;
import java.time.LocalDate;

public class Certificate  implements Serializable {
    final private String certificateID;
    private String weight;
    private String breed;
    private int conditionScore;
    private String doctorName;
    private LocalDate date;

    public Certificate(String certificateID, String weight, String breed, int conditionScore, String doctorName, LocalDate date) {
        this.certificateID = certificateID;
        this.weight = weight;
        this.breed = breed;
        this.conditionScore = conditionScore;
        this.doctorName = doctorName;
        this.date = date;
    }

    public String getCertificateID() {
        return certificateID;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getConditionScore() {
        return conditionScore;
    }

    public void setConditionScore(int conditionScore) {
        this.conditionScore = conditionScore;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "certificateID='" + certificateID + '\'' +
                ", weight='" + weight + '\'' +
                ", breed='" + breed + '\'' +
                ", conditionScore=" + conditionScore +
                ", doctorName='" + doctorName + '\'' +
                ", date=" + date +
                '}';
    }
}

