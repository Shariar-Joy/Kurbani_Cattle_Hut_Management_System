package com.group9.kurbani_cattle_hut_management_system.Joy;

import java.time.LocalDate;

public class AnimalOwner {
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

    private String ownerID;
    private String ownerName;
    private String ownerNID;
    private String ownerAddress;
    private String ownerPhone;

    public AnimalOwner(String animalID, String animalType, String breed, int weight, int age, int askingPrice, LocalDate entryDate, String color, String tent, String status, String ownerID, String ownerName, String ownerNID, String ownerAddress, String ownerPhone) {
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

        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.ownerNID = ownerNID;
        this.ownerAddress = ownerAddress;
        this.ownerPhone = ownerPhone;
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

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNID() {
        return ownerNID;
    }

    public void setOwnerNID(String ownerNID) {
        this.ownerNID = ownerNID;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
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
                ", ownerID='" + ownerID + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerNID='" + ownerNID + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                '}';
    }
}
