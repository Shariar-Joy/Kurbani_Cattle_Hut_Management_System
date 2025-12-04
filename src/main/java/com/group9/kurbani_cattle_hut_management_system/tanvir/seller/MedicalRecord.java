package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalRecord implements Serializable {
    private int medicalRecordId;
    private int animalID;
    private String disease;
    private String status;
    private LocalDate vetRequestDate;
    private LocalDate updatedAt;

    public MedicalRecord(int medicalRecordId, String disease, int animalID) {
        this.medicalRecordId = medicalRecordId;
        this.animalID = animalID;
        this.disease = disease;
        this.status = "Not Treated";
        this.vetRequestDate = LocalDate.now();
        this.updatedAt = null;
    }

    public int getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getVetRequestDate() {
        return vetRequestDate;
    }

    public void setVetRequestDate(LocalDate vetRequestDate) {
        this.vetRequestDate = vetRequestDate;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "medicalRecordId=" + medicalRecordId +
                ", disease='" + disease + '\'' +
                ", status=" + status +
                ", vetRequestDate=" + vetRequestDate +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
