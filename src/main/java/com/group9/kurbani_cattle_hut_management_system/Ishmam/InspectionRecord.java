package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import java.io.Serializable;

public class InspectionRecord implements Serializable {
    private String animalId;
    private String inspectorName;
    private String status;
    private String issueDescription;
    private String checklistResult;

    public InspectionRecord(String animalId, String inspectorName, String status, String issueDescription, String checklistResult) {
        this.animalId = animalId;
        this.inspectorName = inspectorName;
        this.status = status;
        this.issueDescription = issueDescription;
        this.checklistResult = checklistResult;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getChecklistResult() {
        return checklistResult;
    }

    public void setChecklistResult(String checklistResult) {
        this.checklistResult = checklistResult;
    }

    @Override
    public String toString() {
        return "InspectionRecord{" +
                "animalId='" + animalId + '\'' +
                ", inspectorName='" + inspectorName + '\'' +
                ", status='" + status + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", checklistResult='" + checklistResult + '\'' +
                '}';
    }
}