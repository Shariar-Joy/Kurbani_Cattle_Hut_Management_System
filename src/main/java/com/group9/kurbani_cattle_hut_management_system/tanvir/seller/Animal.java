package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import java.io.Serializable;
import java.util.ArrayList;

public class Animal implements Serializable {
    private final int animalId;
    private String ownerEmail;
    private String breed;
    private String age;
    private String sex;
    private float weight;
    private float expectedPrice;
    private String description;
    private String sellStatus; // “Available,” “Reserved,” or “Sold.
    private final ArrayList<String> imageURLS;

    public Animal(int animalID, String ownerEmail, String breed, String age, String sex, float weight, float expectedPrice) {
        this.ownerEmail = ownerEmail;
        this.animalId = animalID;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.expectedPrice = expectedPrice;
        this.description = "";
        this.sellStatus = "Available";
        this.imageURLS = new ArrayList<>();
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(float expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public ArrayList<String> getImageURLS() {
        return imageURLS;
    }

    public void addImageURL(String imageURLS) {
        this.imageURLS.add(imageURLS);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(String sellStatus) {
        this.sellStatus = sellStatus;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ownerEmail='" + ownerEmail + '\'' +
                ", animalId=" + animalId +
                ", breed='" + breed + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", weight=" + weight +
                ", expectedPrice=" + expectedPrice +
                ", description='" + description + '\'' +
                ", sellStatus='" + sellStatus + '\'' +
                ", imageURLS=" + imageURLS +
                '}';
    }
}
