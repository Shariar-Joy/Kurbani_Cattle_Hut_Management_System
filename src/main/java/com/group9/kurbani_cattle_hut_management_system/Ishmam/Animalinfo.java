package com.group9.kurbani_cattle_hut_management_system.Ishmam;

public class Animalinfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String animal;
    private String breed;
    private String seller;
    private String tent;
    private double price;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getTent() {
        return tent;
    }

    public void setTent(String tent) {
        this.tent = tent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Animalinfo(String id, String animal, String breed, String seller, String tent, double price, String time) {
        this.id = id;
        this.animal = animal;
        this.breed = breed;
        this.seller = seller;
        this.tent = tent;
        this.price = price;
        this.time = time;


    }

    @Override
    public String toString() {
        return "Animalinfo{" +
                "id='" + id + '\'' +
                ", animal='" + animal + '\'' +
                ", breed='" + breed + '\'' +
                ", seller='" + seller + '\'' +
                ", tent='" + tent + '\'' +
                ", price=" + price +
                ", time='" + time + '\'' +
                '}';
    }
}



