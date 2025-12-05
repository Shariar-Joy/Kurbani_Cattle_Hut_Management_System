package com.group9.kurbani_cattle_hut_management_system.Ishmam;

public class CartItem {
    private String id;
    private String animal;
    private int quantity;
    private double totalPrice;

    public CartItem(String id, String animal, int quantity, double totalPrice) {
        this.id = id;
        this.animal = animal;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getId() { return id; }
    public String getAnimal() { return animal; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return totalPrice; }

    public void addQuantity(int q, double unitPrice) {
        if (q <= 0) return;
        this.quantity += q;
        this.totalPrice = this.quantity * unitPrice;
    }

    public void setQuantity(int quantity, double unitPrice) {
        this.quantity = quantity;
        this.totalPrice = this.quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id='" + id + '\'' +
                ", animal='" + animal + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

