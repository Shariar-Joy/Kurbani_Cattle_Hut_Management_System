package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProblemReport implements Serializable {
    private String date;
    private String animalId;
    private String animal;
    private String buyerName;
    private String description;
    private String issueType;

    // Constructor
    public ProblemReport(String animalId, String animal, String buyerName, String description, String issueType) {
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.animalId = animalId;
        this.animal = animal;
        this.buyerName = buyerName;
        this.description = description;
        this.issueType = issueType;
    }

    // Getters - REQUIRED for PropertyValueFactory to work
    public String getDate() {
        return date;
    }

    public String getAnimalId() {
        return animalId;
    }

    public String getAnimal() {
        return animal;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getDescription() {
        return description;
    }

    public String getIssueType() {
        return issueType;
    }

    // Setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    @Override
    public String toString() {
        return "ProblemReport{" +
                "date='" + date + '\'' +
                ", animalId='" + animalId + '\'' +
                ", animal='" + animal + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", description='" + description + '\'' +
                ", issueType='" + issueType + '\'' +
                '}';
    }
}