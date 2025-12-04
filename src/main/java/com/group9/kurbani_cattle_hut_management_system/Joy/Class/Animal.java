package com.group9.kurbani_cattle_hut_management_system.Joy.Class;


import java.io.Serializable;
import java.time.LocalDate;

public class Animal implements Serializable {
    private String animalID;
    private String animalType;
    private String breed;
    private int weight;
    private int age;
    private int askingPrice;
    private LocalDate entryDate;
    private String color;
    private String tent;
    private String status;

    public Animal(String animalID, String animalType, String breed, int weight, int age, int askingPrice, LocalDate entryDate, String color, String tent, String status) {
        this.animalID = animalID;
        this.animalType = animalType;
        this.breed = breed;
        this.weight = weight;
        this.age = age;
        this.askingPrice = askingPrice;
        this.entryDate = entryDate;
        this.color = color;
        this.tent = tent;
        this.status = status;
    }

    public String getAnimalID() {
        return animalID;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(int askingPrice) {
        this.askingPrice = askingPrice;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTent() {
        return tent;
    }

    public void setTent(String tent) {
        this.tent = tent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AnimalOwner{" +
                "animalID='" + animalID + '\'' +
                ", animalType='" + animalType + '\'' +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", askingPrice=" + askingPrice +
                ", entryDate=" + entryDate +
                ", color='" + color + '\'' +
                ", tent='" + tent + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
