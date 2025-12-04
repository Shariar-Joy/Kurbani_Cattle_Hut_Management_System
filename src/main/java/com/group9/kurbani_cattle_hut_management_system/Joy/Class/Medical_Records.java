package com.group9.kurbani_cattle_hut_management_system.Joy.Class;

import java.io.Serializable;

public class Medical_Records implements Serializable {
    private String animalID;
    private String temperature;
    private String pulseRate;
    private String breathingRate;
    private String weight;
    private String behavior;
    private String symptoms;
    private String initialDiagnosis;

    public Medical_Records(String animalID, String temperature, String pulseRate, String breathingRate, String weight, String behavior, String symptoms, String initialDiagnosis) {
        this.animalID = animalID;
        this.temperature = temperature;
        this.pulseRate = pulseRate;
        this.breathingRate = breathingRate;
        this.weight = weight;
        this.behavior = behavior;
        this.symptoms = symptoms;
        this.initialDiagnosis = initialDiagnosis;
    }

    public String getAnimalID() {
        return animalID;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getBreathingRate() {
        return breathingRate;
    }

    public void setBreathingRate(String breathingRate) {
        this.breathingRate = breathingRate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getInitialDiagnosis() {
        return initialDiagnosis;
    }

    public void setInitialDiagnosis(String initialDiagnosis) {
        this.initialDiagnosis = initialDiagnosis;
    }

    @Override
    public String toString() {
        return "Medical_Records{" +
                "animalID='" + animalID + '\'' +
                ", temperature='" + temperature + '\'' +
                ", pulseRate='" + pulseRate + '\'' +
                ", breathingRate='" + breathingRate + '\'' +
                ", weight='" + weight + '\'' +
                ", behavior='" + behavior + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", initialDiagnosis='" + initialDiagnosis + '\'' +
                '}';
    }
}

